(function(angular) {
	'use strict';
	angular.module('frontend').run(function($rootScope) {
		$rootScope.REST_URL = 'http://localhost:8090/';
	}).controller('sortController', function($scope, $route, $resource, $rootScope) {
		  $scope.previousValues = [];
		$scope.sortNumber = function() {
			var resource = $resource($rootScope.REST_URL+'sortToAscending');
			resource.get({numbers:$scope.sortNumbers},function(response){
				console.log(response);
				if(response.status == 200){
					$scope.result = true;
					 $scope.resultArray = response.resultArray.sortedArray;
					 $scope.elementPostions = response.resultArray.positionMap;
					 $scope.timeConsumed = response.timeConsumned+"ms";
					 localStorage.setItem('previousSortedArray', response.resultArray.sortedArray);
					 $scope.previousSortedArray = localStorage.getItem('previousSortedArray');
				}
			});
			if($scope.previousSortedArray != null){
				$scope.previousValues.push( $scope.previousSortedArray);
			}
		};
			$scope.reset = function () {
				$scope.sortNumbers = '';
				$scope.result = false;
				$scope.resultArray = '';
				$scope.elementPostions = '';
				$scope.timeConsumed = '';
			   $scope.sortForm.$setPristine();
			}

	});
})(window.angular);