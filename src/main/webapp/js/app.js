'use strict';

// Declare app level module which depends on filters, and services
angular.module('ngdemo', [ 'ngRoute', 'ngdemo.filters', 'ngdemo.services', 'ngdemo.directives', 'ngdemo.controllers' ]).config(
        [ '$routeProvider', function($routeProvider) {
            $routeProvider.when('/receta/nueva', {
                templateUrl : 'partials/receta/receta-new.html',
                controller : 'RecetaCreationController'
            });
            $routeProvider.when('/receta/detalle/:id', {
                templateUrl : 'partials/receta/receta-detail.html',
                controller : 'RecetaDetailController'
            });
            $routeProvider.when('/recetas', {
                templateUrl : 'partials/receta/recetaList.html',
                controller : 'RecetaController'
            });
            $routeProvider.otherwise({
                redirectTo : '/receta/nueva'
            });
        } ]);