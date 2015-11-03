var services = angular.module('ngdemo.services', [ 'ngResource' ]);

services.factory('RecetaFactory', function($resource) {
    return $resource('/ngdemo/rest/recetas/:id', {}, {
        delete : {
            method:'DELETE',
            params:{id: '@id'}
        },
        update : {
            method:'PUT',
            params:{id: '@id'}
        },
        show:{
            method:'GET'
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

services.factory('ProductoFactory', function($resource) {
    return $resource('/ngdemo/rest/productos/:id', {}, {
        delete : {
            method:'DELETE',
            params:{id: '@id'}
        },
        update : {
            method:'PUT',
            params:{id: '@id'}
        },
        show:{
            method:'GET'
        }
    })
});
services.factory('ProductosFactory', function($resource) {
    return $resource('/ngdemo/rest/productos', {}, {
        query : {
            method: 'GET',
            isArray: true
        },
        create : {
            method : 'POST'
        }
    })
});