var app = angular.module('ticketingSystemApp', ['ngResource', 'mgcrea.ngStrap','jcs-autoValidate']);


app.controller('TicketListController', function ($scope, $modal, TicketService) {
    $scope.bugs = TicketService;
    $scope.selectedTicket = TicketService.selectedTicket;
    $scope.isFormDisabled = TicketService.isFormDisabled;
    $scope.selectTicket = function (ticket) {
        $scope.bugs.selectedTicket = ticket;
        console.log($scope.bugs.selectedTicket.status);
        $scope.bugs.isFormDisabled = $scope.bugs.selectedTicket.status == 'Closed';

    };

    $scope.showCreateDialog = function () {
        $scope.bugs.selectedTicket = {};
        $scope.bugs.isFormDisabled = false;
        $scope.createModal = $modal({
            scope: $scope,
            templateUrl: 'templates/modal.create.tpl.html',
            show: true
        });
    }

    $scope.createTicket = function () {
        $scope.bugs.createTicket($scope.bugs.selectedTicket).then(
            function () {
                $scope.createModal.hide();
            }
        );
    }
});

app.controller('TicketDetailController', function ($scope, TicketService) {
    $scope.bugs = TicketService;
    $scope.save = function () {
        $scope.bugs.updateTicket($scope.bugs.selectedTicket);
        $scope.bugs.isFormDisabled = $scope.bugs.selectedTicket.status == 'Closed';
    };

    $scope.remove = function () {
        $scope.bugs.removeTicket($scope.bugs.selectedTicket);
    }



});

app.factory("Ticket", function ($resource) {
    return $resource("tickets/all");
});

app.factory('TicketUpdate', function ($resource) {
    return $resource("tickets/update",
        {id: '@id'}, {
            update: {
                method: 'PUT'
            }
        });
});

app.factory('TicketDelete', function ($resource) {
    return $resource("tickets/delete",
        {id: '@id'}, {
            removeFromServer: {
                method: 'DELETE'
            }
        });
});

app.factory('TicketCreate', function ($resource) {
    return $resource("tickets/create",
        {id: '@id'}, {
            createOnServer: {
                method: 'POST'
            }
        });
});

app.service('TicketService', function (Ticket, TicketUpdate, TicketDelete, TicketCreate, $q) {

    self = {
        'isFormDisabled' : false,
        'selectedTicket': null,
        'tickets': [],
        'loadTickets': function () {

            self.tickets = [];
            console.log("before query");
            Ticket.query(function (data) {
                angular.forEach(data, function (ticket) {
                    self.tickets.push(new Ticket(ticket));
                });
            });
            console.log("after query");
        },
        "updateTicket": function (ticket) {
            TicketUpdate.update(ticket);
        },
        "removeTicket": function (ticket) {
            TicketDelete.removeFromServer(ticket);
            var index = self.tickets.indexOf(ticket);
            self.tickets.splice(index, 1);
            self.selectedTicket = null;
        },
        "createTicket": function (ticket) {
            var deferred = $q.defer();
            TicketCreate.createOnServer(ticket);
            self.selectedTicket = null;
            console.log("created tickets.....")
            self.loadTickets();
            deferred.resolve();
            return deferred.promise;
        }
    };
    self.loadTickets();

    return self;
});
