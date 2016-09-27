var app = angular.module( 'app', [ ] )
    .controller('mainCtrl', function( $scope, $interval ){

        $scope.timerCount = 0;

        $scope.timerDialog = function() {
            $scope.popUpDialogContent = 'Запустить таймер?';
            $scope.popUpDialogCallback = 'activateTimer';
            $scope.showPopUpDialog = true;
        }

        $scope.activateTimer = function() {
            $interval(function(){
                $scope.timerCount++;
            }, 500)
        }

    })

    .directive('popUpDialog', function(){
        return {
            restrict: 'E',
            scope: false,
            template: '<div id="popUpDialog-bg" ng-show="showPopUpDialog"> <div id="popUpDialog"> <div class="content">{{ popUpDialogContent }}</div> <div class="clearfix buttons-container"> <div class="pull-left"> <button class="btn btn-primary" ng-click="popUpDialogApprove()">Да</button> </div> <div class="pull-right"> <button class="btn btn-warning" ng-click="closePopUpDialog()">Нет</button> </div> </div> </div> </div>',
            controller: function( $scope ) {

                $scope.showPopUpDialog = false;

                $scope.closePopUpDialog = function() {
                    $scope.showPopUpDialog = false;
                }

                $scope.popUpDialogApprove = function() {
                    $scope[$scope.popUpDialogCallback]();
                    $scope.showPopUpDialog = false;
                }
            }
        }
    })