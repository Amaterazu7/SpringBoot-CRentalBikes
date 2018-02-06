<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>  
		<meta charset="utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<title>Pack</title>
		<meta name="description" content=""/>
		<meta name="viewport" content="width=device-width"/>
		<base href="/pack"/>
    	<link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.min.css"> 
		<!--  
		<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
		-->
		<link rel="stylesheet" href="/webjars/font-awesome/css/font-awesome.min.css"></link>
	    <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='css/style.css' />" rel="stylesheet"></link>
	    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    	<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
  	<body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="PackController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading">
              	<h2>Pack Registration Form</h2>
              </div>
              <div class="alert alert-dismissible alert-info">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.pack.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Price</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.pack.price" name="price" class="username form-control input-sm" placeholder="Enter Pack Price" required ng-minlength="1"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.price.$error.required">This is a required field</span>
                                      <span ng-show="myForm.price.$error.minlength">Minimum length required is 3</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Number</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.pack.number" class="form-control input-sm" placeholder="Enter Pack Number."/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Profile</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.pack.profile" name="profile" class="username form-control input-sm" placeholder="Enter Pack Profile" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.profile.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
					  
                      <div class="row">
                          <div class="form-actions floatRight" style="padding: 0.9rem;">
                              <input type="submit"  value="{{!ctrl.pack.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading">
              	<h2>List of Packs</h2>
              </div>
              <div class="tablecontainer">
                  <table class="table table-striped table-hover table-bordered">
                      <thead class="thead-dark">
                          	<tr>
                            	<th>ID</th>
                            	<th>Price</th>
                            	<th>Number</th>
                            	<th>Profile</th>
                            	<th width="18%"></th>
                       		</tr>
						</thead>
						<tbody>
                          	<tr ng-repeat="p in ctrl.packs">
								<td><span ng-bind="p.id"></span></td>
								<td><span ng-bind="p.price| currency:'$'""></span></td>
								<td><span ng-bind="p.number"></span></td>
								<td><span ng-bind="p.profile"></span></td>
                              	<td>
                            		<button type="button" ng-click="ctrl.edit(p.id)" class="btn btn-success custom-width">
										<i class="fa fa-pencil-square-o f-2" aria-hidden="true"></i>
									</button>
									<button type="button" ng-click="ctrl.remove(p.id)" class="btn btn-danger custom-width">
										<i class="fa fa-trash f-2" aria-hidden="true"></i>
									</button>
                            	</td>
                        	</tr>
                      	</tbody>
                  	</table>
              	</div>
          	</div>
      	</div>
      
      	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
      	<script src="<c:url value='js/app.js' />"></script>
      	<script src="<c:url value='js/service/pack_service.js' />"></script>
      	<script src="<c:url value='js/controller/pack_controller.js' />"></script>
	</body>
</html>