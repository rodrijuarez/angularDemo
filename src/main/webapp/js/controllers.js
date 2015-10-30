var app = angular.module('ngdemo.controllers', []);

app.controller('RecetaFormController', [ '$scope', 'RecetaFactory', function($scope, RecetaFactory) {
    $scope.guardarReceta = function() {
        RecetaFactory.create($scope.receta);
    }
} ]);

app.controller('RecetaController', [ '$scope', 'RecetaFactory', function($scope, RecetaFactory) {
    $scope.recetas = [];
    alert(RecetaFactory.query());
} ]);

app.controller('MainController', [ '$scope', function($scope) {
} ]);