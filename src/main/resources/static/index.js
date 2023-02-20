angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    // console.log(123);

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                // console.log(response.data)
                $scope.ProductsList = response.data;
            });
    };

    $scope.changePrice = function (productId, delta) {
        console.log(productId);
        $http({
            url: contextPath + '/products/change_price',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }


    $scope.loadProducts();
});