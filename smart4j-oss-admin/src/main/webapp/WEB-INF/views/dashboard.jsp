<%@ page language="java" pageEncoding="utf-8"%>
<script type="text/javascript" src="assets/plugins/My97DatePicker/WdatePicker.js"  ></script>
<style type="text/css">
	.dashboard-stat .detailsDef .number {    
	  /* padding-top: 15px; */
	  text-align: center;
	  font-size: 24px;
	  /* line-height: 34px;
	  letter-spacing: -1px;
	  margin-bottom: 5px; */
	  font-weight: 300;
	  color: #fff;
	}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-6" style="min-width: 30px;">
			<div class="tabbable"> <!-- Only required for left/right tabs -->
			  <ul class="nav nav-tabs">
			    <li class="active"><a class="tag" href="#tab1" data-toggle="tab" id="today" name="tag" value="1">今天</a></li>
	            <li><a class="tag" href="#tab2" data-toggle="tab" id="yestoday" name="tag" value="0">昨天</a></li>
	            <li><a class="tag" href="#tab3" data-toggle="tab" id="lastWeek" name="tag" value="7">最近7天</a></li>
	            <li><a class="tag" href="#tab4" data-toggle="tab" id="lastMonth" name="tag" value="30">最近30天</a></li>
	           <!--  <li><div class="col-sm-6" style="min-width: 100px;margin-left:50px">
			            <form id="dataStatisticsViewSearh" style="top: 15px;"> 
							日期: <input id="custDataViewStartDate" name="startTime" class="easyui-datebox" style="width:110px" value="" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'custDataViewEndDate\')}'})"> 至
				        	<input id="custDataViewEndDate" name="endTime" class="easyui-datebox" style="width:110px" value="" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'custDataViewStartDate\')}'})">
							<a href="javascript:void(0)"  id="dataStatisticsViewSearhBtn" class="easyui-linkbutton btn btn-default" >搜索</a>
						</form>
			        </div>
        		</li> -->
			  </ul>
			  <div class="tab-content">
			    <div class="tab-pane active" id="tab1">
			      <p></p>
			    </div>
			    <div class="tab-pane active" id="tab2">
			      <p></p>
			    </div>	
			    <div class="tab-pane active" id="tab3">
			      <p></p>
			    </div>
			    <div class="tab-pane active" id="tab4">
			      <p></p>
			    </div>	    
			  </div>
			</div>       
        </div>       
    	<div class="col-sm-6" style="min-width: 100px;">
           <form id="dataStatisticsViewSearh" style="top: 15px;"> 
			日期: <input id="custDataViewStartDate" name="startTime" class="easyui-datebox" style="width:110px" value="" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'custDataViewEndDate\')}'})"> 至
        	<input id="custDataViewEndDate" name="endTime" class="easyui-datebox" style="width:110px" value="" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'custDataViewStartDate\')}'})">
			<a href="javascript:void(0)"  id="dataStatisticsViewSearhBtn" class="easyui-linkbutton btn btn-default" >搜索</a>
		</form>
       </div>
    </div>
       
    <div class="row">
	    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
	        <div class="dashboard-stat blue">
	            <!-- <div class="visual">
	                <i class="fa fa-comments"></i>
	            </div> -->
	            <div class="detailsDef">
	                <div id="newCustomer" class="number"></div>
	            </div>
	            <a class="more" href="#">新增客户数（人）<i class="m-icon-swapright m-icon-white"></i>
	            </a>
	        </div>
	    </div>
	    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
	        <div class="dashboard-stat blue">
	            <!-- <div class="visual">
	                <i class="fa fa-comments"></i>
	            </div> -->
	            <div class="detailsDef">
	                <div id="totalCustomer" class="number"></div>
	            </div>
	            <a class="more" href="#">累计客户数（人）<i class="m-icon-swapright m-icon-white"></i>
	            </a>
	        </div>
	    </div>
	    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
	        <div class="dashboard-stat green">
	            <!-- <div class="visual">
	                <i class="fa fa-bar-chart"></i>
	            </div> -->
	            <div class="detailsDef">
	                <div id="newOrderNum" class="number"></div>
	            </div>
	            <a class="more" href="#">新增订单数（个）<i class="m-icon-swapright m-icon-white"></i>
	            </a>
	        </div>
	    </div>
	    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
	        <div class="dashboard-stat green">
	            <!-- <div class="visual">
	                <i class="fa fa-bar-chart"></i>
	            </div> -->
	            <div class="detailsDef">
	                <div id="totalOrderNum" class="number"></div>
	            </div>
	            <a class="more" href="#">累计订单数（个）<i class="m-icon-swapright m-icon-white"></i>
	            </a>
	        </div>
	    </div>
	    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
	        <div class="dashboard-stat yellow">
	            <!-- <div class="visual">
	                <i class="fa fa-money"></i>
	            </div> -->
	            <div class="detailsDef">
	                <div id="newSaleAmount" class="number"></div>
	            </div>
	            <a class="more" href="#">新增销售额（元）<i class="m-icon-swapright m-icon-white"></i>
	            </a>
	        </div>
	    </div>	        
	    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
	        <div class="dashboard-stat yellow">
	            <!-- <div class="visual">
	                <i class="fa fa-money"></i>
	            </div> -->
	            <div class="detailsDef">
	                <div id="totalSaleAmount" class="number"></div>
	            </div>
	            <a class="more" href="#">累计销售额（元）<i class="m-icon-swapright m-icon-white"></i>
	            </a>
	        </div>
	    </div>	    
	</div>
    
    <div class="row">
        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
            <div id="customerStatistics" style="min-height: 300px;"></div>
        </div>
        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
            <div id="orderNumStatistics" style="min-height: 300px;"></div>
        </div>
        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
            <div id="saleAmountStatistics" style="min-height: 300px;"></div>
        </div>      
    </div>

</div>

 <script type="text/javascript" src="app/common/util.js"></script>
 <script type="text/javascript" > 
 $(document).ready(function() {
	/*var params = {tag:1};	
	var path = 'rest/data/statistics/tag';
	loadView(path,params);*/
 }); 

 function loadView(path,params){
	  
	 $.getJSON(path,params, function (json) {
		 
		 $('#newCustomer').text(json.data.count.newCustomer);
		 $('#newOrderNum').text(json.data.count.newOrderNum);
		 $('#newSaleAmount').text(json.data.count.newSaleAmount==undefined?0:Number(json.data.count.newSaleAmount/100).toFixed(0));
		 $('#totalCustomer').text(json.data.count.totalCustomer);
		 $('#totalOrderNum').text(json.data.count.totalOrderNum);
		 $('#totalSaleAmount').text(json.data.count.totalSaleAmount==undefined?0:Number(json.data.count.totalSaleAmount/100).toFixed(0));
	
		 var customerCategories = [];  
		 var customerValues = [];
		 		 
		 var orderNumCategories = [];  
		 var orderNumValues = [];
		 
		 var saleAmountCategories = [];  
		 var saleAmountValues = [];
		 	 
		 var customerData = json.data.customer;
		 $.each(customerData,function(i,data){
			 customerCategories.push(data.registerCustomerTime);
			 customerValues.push(data.registerCustomerNum);
		 });
		 
		 var orderNumData = json.data.orderNum;
		 $.each(orderNumData,function(i,data){
			 orderNumCategories.push(data.orderCreateTime);
			 orderNumValues.push(data.orderNum);
		 });
		 
		 var saleAmountData = json.data.saleAmount;
		 $.each(saleAmountData,function(i,data){
			 saleAmountCategories.push(data.saleTime);
			 saleAmountValues.push(Number(data.saleAmount/100).toFixed(0));
		 }); 
		 
		 var customerStatistics = echarts.init(document.getElementById('customerStatistics'));
		 var customerOption = {
			 title: {
			        text: '新增客户数'
			 },
		     tooltip: {
		    	 trigger: 'axis'
		     },
		     toolbox: {  
	             show : true,  
	             feature : {  
	                 mark : {show: true},  
	                 magicType : {show: true, type: ['line', 'bar']}
	             }  
	         },
		     legend: {
		         data:['新增客户数']
		     },
		     calculable : true, 
		     xAxis: {
		    	 type : 'category',
		         data: customerCategories,
		         boundaryGap: false
		     },
		     yAxis: {
		    	 type: 'value',
		    	 min:0,
		         boundaryGap: false
		     },
		     series: [{
		         name: '人数',
		         type:'line',
		         data: customerValues
		     }]
		 };
		 customerStatistics.setOption(customerOption);
		
		 var orderNumStatistics = echarts.init(document.getElementById('orderNumStatistics'));
		 var orderNumOption = {
			 title: {
			        text: '新增订单数'
			 },
		     tooltip: {
		    	 trigger: 'axis'
		     },
		     toolbox: {  
	             show : true,  
	             feature : {  
	                 mark : {show: true},  
	                 magicType : {show: true, type: ['line', 'bar']}
	             }  
	         },
		     legend: {
		         data:['新增订单数']
		     },
		     calculable : true, 
		     xAxis: {
		    	 type : 'category',
		         data: orderNumCategories,
		         boundaryGap: false
		     },
		     yAxis: {
		    	 type: 'value',
		    	 min:0,
		         boundaryGap: false
		     },
		     series: [{
		         name: '订单数',
		         type:'line',
		         data: orderNumValues
		     }]
		 };
		 orderNumStatistics.setOption(orderNumOption);
		 
		 var saleAmountStatistics = echarts.init(document.getElementById('saleAmountStatistics'));
		 var saleAmountOption = {
			 title: {
			        text: '新增销售额'
			 },	 
		     tooltip: {
		    	 trigger: 'axis'
		     },
		     toolbox: {  
	             show : true,  
	             feature : {  
	                 mark : {show: true},  
	                 magicType : {show: true, type: ['line', 'bar']}
	             }  
	         },
		     legend: {
		         data:['新增销售额']
		     },
		     calculable : true, 
		     xAxis: {
		    	 type : 'category',
		         data: saleAmountCategories,
		         boundaryGap: false
		     },
		     yAxis: {
		    	 type: 'value',
		    	 min:0,
		         boundaryGap: false
		     },
		     series: [{
		         name: '金额',
		         type:'line',
		         data: saleAmountValues
		     }]
		 };
		 saleAmountStatistics.setOption(saleAmountOption); 
		 
	 }); 
 }
	$('#dataStatisticsViewSearhBtn').click(function() {
		var params=jsonFromt($('#dataStatisticsViewSearh').serializeArray());
		var path = 'rest/data/statistics';
		loadView(path,params);
	});
	$('.tag').click(function(e) {
		var tag = $(e.target).attr("value");
		var params = {tag:tag};	
		var path = 'rest/data/statistics/tag';
		loadView(path,params);
	});
 </script>