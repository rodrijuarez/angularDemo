var services = angular.module('ngdemo.services', [ 'ngResource' ]);

services.factory('RecetaFactory', function($resource) {
    return $resource('/ngdemo/rest/recetas/:id', {}, {
        delete : {
            method:'DELETE',
            params:{id: '@id'}
        }
    })
});
services.factory('RecetasFactory', function($resource) {
    return $resource('/ngdemo/rest/recetas', {}, {
        query : {
            method: 'GET',
            isArray: true
        },
        create : {
            method : 'POST'
        }
    })
});