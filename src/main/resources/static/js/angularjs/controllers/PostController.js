app.controller('PostController', function($scope, $rootScope, $location, $window, $http, UtilService, PostResource ) {



    $scope.post={};

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            $.growl.notice({ message: "Shared successfully!" });
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        PostResource.save($scope.post, successCallback, errorCallback);
    };


    $scope.getPrivacyList = function() {
        var successCallback = function(data,responseHeaders) {
            $scope.privacyList = data.model;
            console.log($scope.privacyList)
            $scope.totalSize = data.total;
        };
        var errorCallback = function() {
            console.log('error');
        };

        PostResource.getPrivacyList({},successCallback, errorCallback);
    };

    $scope.getLocationList = function() {
        var successCallback = function(data,responseHeaders) {
            $scope.locationList = data.model;
            console.log($scope.locationList);
            $scope.totalSize = data.total;
        };
        var errorCallback = function() {
            console.log('error');
        };

        PostResource.getLocationList({},successCallback, errorCallback);
    };


    $scope.getPrivacyList();
    $scope.getLocationList();



});