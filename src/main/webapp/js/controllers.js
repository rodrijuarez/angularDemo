var app = angular.module('ngdemo.controllers', []);

app.controller('MiControlador', [ '$scope', 'UserFactory', function($scope, UserFactory) {
    UserFactory.get({}, function(userFactory) {
        $scope.firstname = userFactory.firstName;
    })
} ]);

app.controller('MainController', [ '$scope', function($scope) {
} ]);
