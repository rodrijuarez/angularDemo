var services = angular.module('ngdemo.services', ['ngResource']);

services.factory('RecetaFactory', function ($resource) {
    return $resource('/rest/recetas', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        },
        create: {
            method: 'POST'
        }
    })
});