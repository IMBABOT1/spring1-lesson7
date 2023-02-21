angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

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

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/'+ productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }



    $scope.filter = function () {
        console.log($scope.calcAdd);
        $http({
            url: contextPath + '/products/price_between',
            method: 'get',
            params: {
                min: $scope.filter.min,
                max: $scope.filter.max
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
            $scope.filter.min = null;
            $scope.filter.max = null;
        });
    }



    $scope.loadProducts();
});
