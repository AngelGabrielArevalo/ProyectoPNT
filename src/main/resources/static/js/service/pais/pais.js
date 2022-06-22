escuelita.service.pais = (function () {

    var urlService = "/api/pais/";

    function buscarPorId(idPais) {
        var urlServiceBuscarPorId = urlService + idPais;
        return $.get(urlServiceBuscarPorId);
    }

    return {
        buscarPorId: buscarPorId
    };

})();