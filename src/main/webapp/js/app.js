'use strict';

// Declare app level module which depends on filters, and services
angular.module('ngdemo', ['ngdemo.filters', 'ngdemo.services', 'ngdemo.directives', 'ngdemo.controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/receta/nueva', {templateUrl: 'partials/receta/recetaForm.html', controller: 'RecetaController'});
        $routeProvider.otherwise({redirectTo: '/receta/nueva'});
    }]);