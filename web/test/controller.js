var clientApp = angular.module('clientApp', ['ngRoute', 'ngResource']);
clientApp.factory('Clients',[
    '$resource', function ($resource) {
        return $resource('client/clients/:clientId', {}, {
                update: { method: 'PUT' }
            }
        );
    }
]);
clientApp.controller('ClientList', function ($scope, Clients, $route) {
    $scope.clients = Clients.query();
    $scope.AddMessage = 'Add new client';

    $scope.AddClick = function () {
        $scope.showPopUpDialog = true;
        $scope.ifTrueThenAdd = true;
        $scope.AddOrEditMessage = $scope.AddMessage;
    };
    $scope.Delete = function (id) {
        Clients.delete({clientId:id});
        $scope.clients = Clients.query();
        $route.reload();
    };
});
clientApp.directive('popUpDialog', function () {
    return{
        restrict:'E',
        scope:false,
        templateUrl:'/test/addEditForm.html',
        controller:function($scope, $route, Clients) {
            var EditMessage = 'Edit client';
            $scope.AddOrEditMessage = $scope.AddMessage;
            $scope.showPopUpDialog = false;
            $scope.ifTrueThenAdd = true;
            $scope.EditClick = function (id) {
                $scope.showPopUpDialog = true;
                $scope.ifTrueThenAdd = false;
                $scope.AddOrEditMessage = EditMessage;
                $scope.newclient = Clients.get({clientId: id});
            };
            $scope.AddOrEdit = function (add) {
                $scope.newclient.birthday = document.getElementById('_birthday').value;
                if (add)
                    $scope.Add();
                else
                    $scope.Edit();
                $scope.showPopUpDialog = false;
            };
            $scope.Add = function () {
                document.getElementById('myForm').reset();
                Clients.save($scope.newclient);
                $scope.clients = Clients.query();
                $route.reload();
            };
            $scope.Edit = function () {
                document.getElementById('myForm').reset();
                Clients.update($scope.newclient);
                $scope.clients = Clients.query();
                $route.reload();
            };
            $scope.closePopUpDialog = function () {
                document.getElementById('myForm').reset();
                $scope.showPopUpDialog = false;
            }

        }
    }
});
clientApp.directive('validation', function() {
    return {
        require: 'ngModel',
        link: function($scope, element, attr, ClientList) {
            function myValidation(value) {
                $scope.ids = [];
                $scope.clients.forEach(function(cl) {
                    $scope.ids.push(cl.id);
                });
                var ok = true;
                var i=0;
                while(i<$scope.ids.length && ok){
                    if ($scope.ids[i] == value){
                        ok = false;
                    }
                    i++;
                }
                if (ok){
                    ClientList.$setValidity('unique', true);
                } else {
                    ClientList.$setValidity('unique', false);
                }
                return value;
            }
            ClientList.$parsers.push(myValidation);
        }
    };
});
