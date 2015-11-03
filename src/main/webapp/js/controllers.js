var app = angular.module('ngdemo.controllers', ['ngAnimate','vModal','ngSanitize', 'ngCsv','uiGmapgoogle-maps']);

app.factory('myModal', function (vModal) {
    return vModal({
        controller: 'MyModalController',
        controllerAs: 'myModalCtrl',
        templateUrl: 'partials/modals/myModal.html'
      });
    })

app.controller('MyModalController', function (myModal) {
  this.close = myModal.deactivate;
})

app.controller('MainController', function (myModal,$scope) {
    $scope.abrirAcercaDe = myModal.activate;
  })
    
app.controller('RecetaCreationController', [ '$scope', 'RecetasFactory','$location','myModal', function($scope, RecetasFactory,$location,myModal) {
    $scope.receta = {};
    $scope.receta.productos = [];
    $scope.guardarReceta = function() {
        RecetasFactory.create($scope.receta);
        $location.path('/recetas');
    };
    $scope.addProducto = function(){
        $scope.receta.productos.push({});
    };
} ]);

app.controller('RecetaDetailController', [ '$scope', 'RecetaFactory','$routeParams','$location', function($scope,RecetaFactory,$routeParams, $location) {
    
    $scope.actualizarReceta = function() {
        RecetaFactory.update($scope.receta);
        $location.path('/recetas');
    };
    $scope.receta = RecetaFactory.show({id: $routeParams.id});
} ]);

app.controller('RecetaController', [ 'RecetaFactory','RecetasFactory','$location', function(RecetaFactory,RecetasFactory,$location) {
    var vm = this;
    vm.init = function(){
        vm.cargarRecetas();
    };
    
    vm.editReceta = function (recetaId) {
        $location.path('/receta/detalle/' + recetaId);
    };
    
    vm.cargarRecetas = function(){
        vm.recetas = RecetasFactory.query();   
    };
    
    vm.deleteReceta = function(recetaId){
        RecetaFactory.delete({id:recetaId},vm.cargarRecetas);
    };
    
    vm.init();
} ]);



app.controller('ProductoCreationController', [ '$scope', 'ProductosFactory','$location','myModal', function($scope, ProductosFactory,$location,myModal) {
    $scope.guardarProducto = function() {
        ProductosFactory.create($scope.producto);
        $location.path('/productos');
    };
} ]);

app.controller('ProductoDetailController', [ '$scope', 'ProductoFactory','$routeParams','$location', function($scope,ProductoFactory,$routeParams, $location) {
    
    $scope.actualizarProducto = function() {
        ProductoFactory.update($scope.producto);
        $location.path('/productos');
    };
    $scope.producto = ProductoFactory.show({id: $routeParams.id})
} ]);

app.controller('ProductoController', [ 'ProductoFactory','ProductosFactory','$location', function(ProductoFactory,ProductosFactory,$location) {
    var vm = this;
    vm.init = function(){
        vm.cargarProductos();
    };
    
    vm.editProducto = function (productoId) {
        $location.path('/producto/detalle/' + productoId);
    };
    
    vm.cargarProductos = function(){
        vm.productos = ProductosFactory.query();   
    };
    
    vm.deleteProducto = function(productoId){
        ProductoFactory.delete({id:productoId},vm.cargarProductos);
    };
    
    vm.init();
} ]);

app.controller('LocalController', function ($scope,uiGmapIsReady,$timeout) {
    $scope.map = {center: {latitude: -34.6122402, longitude: -58.394864 }, zoom: 14, bounds: {} };
    $scope.options = {scrollwheel: true};
    $scope.locales = [];
    $scope.locales.push({id:1,latitude:-34.6122402,longitude:-58.394864,title:'Ugi'});
})