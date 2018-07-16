var editor; // use a global for the submit and return data rendering in the examples
var permissionList=[];

$(document).ready(function() {
    editor = new $.fn.dataTable.Editor( {
    	ajax: {
            create: {
                type: 'POST',
                url:  'rest/biz/platform/save',
                data:function(d){return {'rows':JSON.stringify(d)};}
            },
            edit: {
                type: 'POST',
                url:  'rest/biz/platform/save',
                data:function(d){return {'rows':JSON.stringify(d)};}
            },
            remove: {
            	 type: 'POST',
                 url:  'rest/biz/platform/save',
                 data:function(d){return {'rows':JSON.stringify(d)};}
            }
        },
        table: "#dtable",
        idSrc:  'id',
        i18n: {
            "create": {
                "button": "新增",
                "title":  "创建新的实体",
                "submit": "确定"
            },
            "edit": {
                "button": "编辑",
                "title":  "编辑实体",
                "submit": "确定"
            },
            "remove": {
                "button": "删除",
                "title":  "删除",
                "submit": "确定",
                "confirm": {
                    "_": "确定要删除选择的 %d 行数据吗?",
                    "1": "确定要删除选择的 1 行数据吗?"
                }
            },
         
            "error": {
                "system": "发生系统错误 (More information)"
            },
         
            "multi": {
                "title": "多个值",
                "info": "选择的内容中当前输入框包含不同的值. 把他们设置成相同的值, 点击这里, 否则它们仍然保留不同的值.",
                "restore": "取消改动"
            },
         
            "datetime": {
                "previous": '前',
                "next":     '后',
                "months":   [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月' ],
                "weekdays": [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ],
                "amPm":     [ '上午', '下午' ],
                "unknown":  '-'
            }
        },
        fields: [
         {
                label: "自增主键:",
                name: "id"
                ,type:"hidden"
            }, 
         {
                label: "平台名称:",
                name: "name"
            }, 
         {
                label: "平台logo:",
                name: "logo"
            }, 
         {
                label: "首复投",
                name: "aors",
                type:"select",
                options: [
                          { label: "首投", value: 1 },
                          { label: "复投",  value: 2 },
                          { label: "首投+复投", value: 3 }
                      ],
                      def: 1
            }, 
         {
                label: "标签id，逗号分隔:",
                name: "tags"
            }, 
         {
                label: "风控信息-类型:",
                name: "rcType",
                type:"select",
                options: [
                          { label: "保守型", value: "A" },
                          { label: "稳健型", value: "B" },
                          { label: "进取型", value: "C" },
                          { label: "激进型", value: "D" },
                          { label: "高返型", value: "E" }
                      ],
                      def: "C"
            }, 
         {
                label: "风控信息-等级:",
                name: "rcLevel",
                type: "select",
                options: [
                          { label: "A", value: "A" },
                          { label: "B", value: "B" },
                          { label: "C", value: "C" },
                          { label: "D", value: "D" },
                          { label: "E", value: "E" }
                      ],
                      def: "C"
            }, 
         {
                label: "融资背景:",
                name: "bgRz"
            }, 
         {
                label: "平台背景:",
                name: "bgPt"
            }, 
         {
                label: "银行存管:",
                name: "bank"
            }, 
         {
                label: "ICP:",
                name: "icp"
            }, 
         {
                label: "提现速度:",
                name: "txSpeed"
            }, 
         {
                label: "所属公司:",
                name: "cname"
            }, 
         {
                label: "注册资本:",
                name: "zczb"
            }, 
         {
                label: "上线时间:",
                name: "onlinetime"
            }, 
         {
                label: "平台介绍:",
                name: "memo",
                type:"textarea"
            }, 
         {
                label: "注册地址:",
                name: "link"
            }, 
         {
                label: "神盾风控地址:",
                name: "url"
            }, 
         {
                label: "详细说明:",
                name: "detail",
                type:"textarea"
            }, 
         {
                label: "最小投资天数:",
                name: "dmin"
            }, 
         {
                label: "最大投资天数:",
                name: "dmax"
            }, 
            {
            	label: "已投资人数:",
            	name: "maxInvestors"
            }, 
         {
                label: "推荐:",
                name: "tui",
                type:"select",
                options: [
                          { label: "推荐", value: 1 },
                          { label: "不推荐",  value: 0 }
                      ],
                      def: 1
            }, 
         {
                label: "状态",
                name: "status",
                type:"select",
                options: [
                          { label: "审核中", value: 0 },
                          { label: "上线",  value: 1 },
                          { label: "暂停", value: 2 }
                      ],
                      def: 1
            }, 
         {
                label: "是否要求截图:",
                name: "requiredImage",
                type:"select",
                options: [
                          { label: "不需要", value: 0 },
                          { label: "需求",  value: 1 }
                      ],
                      def: 0
            }, 
         {
                label: "是否要求用户名:",
                name: "requiredName",
                type:"select",
                options: [
                          { label: "不需要", value: 0 },
                          { label: "需求",  value: 1 }
                      ],
                      def: 0
            }, 
        ]
    } );
    //前端校验
    editor.on( 'preSubmit', function ( e, o, action ) {
        if ( action !== 'remove' ) {
            var name = editor.field( 'name' );
            var onlinetime = editor.field( 'onlinetime' );
 
            // Only validate user input values - different values indicate that
            // the end user has not entered a value
            if ( ! name.isMultiValue() ) {
                if ( ! name.val() ) {
                	name.error( '该字段必填' );
                }
                 
                if ( name.val().length <= 2 ) {
                	name.error( '该字段长度必须超过 2个字符' );
                }
            }
            if ( ! onlinetime.isMultiValue() ) {
            	if ( ! onlinetime.val() ) {
            		onlinetime.error( '该字段必填' );
            	}
            }
 
            // ... additional validation rules
 
            // If any error was reported, cancel the submission so it can be corrected
            if ( this.inError() ) {
                return false;
            }
        }
    } );
    var shiro_admin = "disabled=true";
    if($('#shiro_admin')){
    	shiro_admin = "";
    }
    var table = $('#dtable').DataTable( {
    	dom: "Bfrtip",
        "processing": true,
        "serverSide": true,
        "language": {
        	select: {
                rows: {
                    _: "已选择 %d 行",
                    1: "已选择 1 行"
                }
            },
        	"sProcessing":   "处理中...",
        	"sLengthMenu":   "显示 _MENU_ 项结果",
        	"sZeroRecords":  "没有匹配结果",
        	"sInfo":         "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        	"sInfoEmpty":    "显示第 0 至 0 项结果，共 0 项",
        	"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
        	"sInfoPostFix":  "",
        	"sSearch":       "搜索:",
        	"sUrl":          "",
        	"sEmptyTable":     "表中数据为空",
        	"sLoadingRecords": "载入中...",
        	"sInfoThousands":  ",",
        	"oPaginate": {
        		"sFirst":    "首页",
        		"sPrevious": "上页",
        		"sNext":     "下页",
        		"sLast":     "末页"
        	},
        	"oAria": {
        		"sSortAscending":  ": 以升序排列此列",
        		"sSortDescending": ": 以降序排列此列"
        	}
        },
        "ajax": {
            "url": "/rest/biz/platform/list",
            "type": "POST",
            "data":function(d){return {'_dt_json':JSON.stringify(d)};}//传递对象太多，json化
        },
        "columns": [
            { "data": "id","orderable": false },
            { "data": "name","orderable": false },
            { "data": "logo","render": function ( data, type, row, meta ) {
            	if(data.length>10)
                    return data.substr(0,10)+'...';
            	else return data;
                },"orderable": false },
            { "data": "aors","orderable": false },
            { "data": "tags","orderable": false },
            { "data": "rcType","orderable": false },
            { "data": "rcLevel","orderable": false },
            { "data": "bgRz","orderable": false },
            { "data": "bgPt","orderable": false },
            { "data": "bank","orderable": false },
            { "data": "icp","orderable": false },
            { "data": "txSpeed","orderable": false },
            { "data": "cname","render": function ( data, type, row, meta ) {
            	if(data.length>10)
                    return data.substr(0,10)+'...';
            	else return data;
                },"orderable": false },
            { "data": "zczb","orderable": false },
            { "data": "onlinetime","orderable": false },
            { "data": "memo","render": function ( data, type, row, meta ) {
            	if(data.length>10)
                return data.substr(0,10)+'...';
            	else return data;
            },"orderable": false },
            { "data": "link","render": function ( data, type, row, meta ) {
            	if(data.length>10)
                    return data.substr(0,10)+'...';
            	else return data;
                },"orderable": false },
            { "data": "url","render": function ( data, type, row, meta ) {
            	if(data.length>10)
                    return data.substr(0,10)+'...';
            	else return data;
                },"orderable": false },
            { "data": "detail","render": function ( data, type, row, meta ) {
            	if(data.length>10)
                    return '...';
            	else return data;
                },"orderable": false ,"visible":false},
            { "data": "dmin","orderable": false ,"visible":false},
            { "data": "dmax","orderable": false ,"visible":false},
            { "data": "maxInvestors","orderable": false ,"visible":false},
            { "data": "tui","render": function ( data, type, row, meta ) {
            	return data===1?"推荐":"不推荐";
            },"orderable": false ,"visible":false},
            { "data": "status","render": function ( data, type, row, meta ) {
            	return data===1?"已上线":"暂停";
                },"orderable": false },
            { "data": "requiredImage","orderable": false,"visible":false },
            { "data": "requiredName","orderable": false,"visible":false },
			    
        ],
        select: true,
        buttons: [
            { extend: "create", editor: editor },
            { extend: "edit",   editor: editor },
            { extend: "remove", editor: editor }
        ]
    } );
    
} );
