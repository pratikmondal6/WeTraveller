var app = angular.module('edms', ['ngRoute', 'ngResource'], function ($interpolateProvider) {});

app.directive('onErrorSrc', function ($rootScope) {
    return {
        link: function (scope, element, attrs) {
            element.bind('error', function () {
                if (attrs.src != attrs.onErrorSrc) {
                    attrs.$set('src', $rootScope.baseUrl + $rootScope.blankImage);
                }
            });
        }
    }
});

app.config(['$httpProvider', '$routeProvider', '$controllerProvider', function($httpProvider, $routeProvider, $controllerProvider,  $window) {
    $httpProvider.interceptors.push('redirectInterceptor');
    app.registerCtrl = $controllerProvider.register;
}])
.run(function($rootScope, $window) {
    console.log("Apps is running...");
    $rootScope.baseUrl = "";
    $rootScope.blankImage = "/src/images/blank_avatar.png";
})
    .factory('redirectInterceptor', function($q, $location, $window, $rootScope){
    return  {
        'response':function(response){
            //console.log(response);
            if (typeof response.data === 'string' && response.data.indexOf("/login")>-1) {
                $.LoadingOverlay("hide");
                $.growl.error({ message: "You've been logged out. Please login back."});
                setTimeout(function () {
                    $window.open("/", '_blank');
                }, 3000);
                return $q.reject(response);
            }else{
                return response;
            }
        }
    }
});
