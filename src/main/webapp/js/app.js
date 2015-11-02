'use strict';

// Declare app level module which depends on filters, and services
angular.module('ngdemo', [ 'ngRoute', 'ngdemo.filters', 'ngdemo.services', 'ngdemo.directives', 'ngdemo.controllers' ]).config(
        [ '$routeProvider', 'uiGmapGoogleMapApiProvider', function($routeProvider, uiGmapGoogleMapApiProvider) {
            uiGmapGoogleMapApiProvider.configure({
                key : 'AIzaSyCxb37T9TC2xma21OAQ5mptPDQXNi-n_uA',
                v : '3.20', // defaults to latest 3.X anyhow
                libraries : 'weather,geometry,visualization'
            });
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
                controller : 'RecetaController',
                controllerAs : 'vm'
            });
            $routeProvider.when('/local', {
                templateUrl : 'partials/others/local.html',
                controller : 'LocalController'
            });
            $routeProvider.otherwise({
                redirectTo : '/receta/nueva'
            });
        } ]);