var clientApp = angular.module('clientApp', ['ngRoute', 'ngResource']);
clientApp.factory('Clients',[
    '$resource', function ($resource) {
        return $resource('client/clients/:clientId', {}, {
                update: { method: 'PUT' }
            }
        );
    }
]);
clientApp.controller('ClientList', function ($scope, $http, Clients) {
    $scope.clients = Clients.query();
    $scope.edit = -1;
    $scope.Add = function () {
        Clients.save($scope.newclient);
        $scope.clients = Clients.query();
    };
    $scope.Delete = function (id) {
        var ans = confirm('Are you sure to delete it?');
        if (ans){
            Clients.delete({clientId: id});
        }
        $scope.clients = Clients.query();
    };
    $scope.EditClick = function (id) {
        $scope.edit = id;
        $scope.oldclient = Clients.get({clientId: id});
    };
    $scope.Edit = function () {
        $scope.edit = id;
        $scope.oldclient = Clients.get({clientId: id});
        Clients.update($scope.oldclient);
        $scope.edit = -1;
        $scope.clients = Clients.query();
    };
});

