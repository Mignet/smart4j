var editor; // use a global for the submit and return data rendering in the examples
var permissionList=[];

$(document).ready(function() {
    editor = new $.fn.dataTable.Editor( {
    	ajax: {
            create: {
                type: 'POST',
                url:  'rest/biz/plan/save',
                data:function(d){return {'rows':JSON.stringify(d)};}
            },
            edit: {
                type: 'POST',
                url:  'rest/biz/plan/save',
                data:function(d){return {'rows':JSON.stringify(d)};}
            },
            remove: {
            	 type: 'POST',
                 url:  'rest/biz/plan/save',
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
                label: ":",
                name: "id"
                ,type:"hidden"
            }, 
         {
                label: "平台id:",
                name: "pid"
            }, 
         {
                label: "方案名称:",
                name: "name"
            }, 
         {
                label: "方案类型:",
                name: "type",
                type:  "select",
                options: [
                    { label: "首投", value: 0 },
                    { label: "复投",  value: 1 }
                ],
                def: 0
            }, 
         {
                label: "投资项目:",
                name: "product"
            }, 
         {
                label: "投资金额:",
                name: "mount"
            }, 
         {
                label: "投资上限:",
                name: "mountMax"
            }, 
         {
                label: "返利:",
                name: "fanli"
            }, 
         {
                label: "奖励:",
                name: "jiangli"
            }, 
         {
                label: "参考年化利率:",
                name: "yearate"
            }, 
         {
                label: "红包:",
                name: "hongbao"
            }, 
         {
                label: "体验金:",
                name: "tiyanjin"
            }, 
         {
                label: "其他:",
                name: "other"
            }, 
         {
                label: "周期:",
                name: "touzizhouqi"
            }, 
         {
                label: "总收益(参考):",
                name: "shouyi"
            }, 
         {
                label: "综合年化(参考):",
                name: "yearfee"
            }, 
         {
                label: "返利周期:",
                name: "fanlizhouqi"
            }, 
         {
                label: "状态:",
                name: "status",
                type:  "select",
                options: [
                          { label: "无效", value: 0 },
                          { label: "有效",  value: 1 }
                      ],
                      def: 1
            }, 
        ]
    } );
    //前端校验
    editor.on( 'preSubmit', function ( e, o, action ) {
        if ( action !== 'remove' ) {
            var name = editor.field( 'name' );
 
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
            "url": "/rest/biz/plan/list",
            "type": "POST",
            "data":function(d){return {'_dt_json':JSON.stringify(d)};}//传递对象太多，json化
        },
        "columns": [
            { "data": "id","orderable": false },
            { "data": "pid","orderable": false },
            { "data": "name","orderable": false },
            { "data": "type",render:function(data){
            	return data===0?"首投":"复投";
            },"orderable": false },
            { "data": "product","orderable": false },
            { "data": "mount","orderable": false },
            { "data": "mountMax","orderable": false },
            { "data": "fanli","orderable": false },
            { "data": "jiangli","orderable": false },
            { "data": "yearate","orderable": false },
            { "data": "hongbao","orderable": false },
            { "data": "tiyanjin","orderable": false },
            { "data": "other","orderable": false },
            { "data": "touzizhouqi","orderable": false },
            { "data": "shouyi","orderable": false },
            { "data": "yearfee","orderable": false },
            { "data": "fanlizhouqi","orderable": false },
            { "data": "status",render:function(data){
            	return data===1?"有效":"无效";
            },"orderable": false },
			    
        ],
        select: true,
        buttons: [
            { extend: "create", editor: editor },
            { extend: "edit",   editor: editor },
            { extend: "remove", editor: editor }
        ]
    } );
    
} );
