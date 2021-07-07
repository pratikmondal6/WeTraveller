/**
 * Created by pratik.mondal on 7/7/2021.
 */

app.factory('PostResource', function ($resource, $rootScope) {
    var baseUrl = $rootScope.baseUrl;
    var resource = {};
    var resource = $resource(baseUrl,{},
        {
            'savePost': { method: 'POST', url: baseUrl + '/api/v1/post/save-risk', isArray: false },
            'getPrivacyList': { method: 'GET', url: baseUrl + '/api/v1/post/getPrivacyList', isArray: false },
            'getLocationList': { method: 'GET', url: baseUrl + '/api/v1/post/getLocationList', isArray: false },
        }
    );
    return resource;
});
