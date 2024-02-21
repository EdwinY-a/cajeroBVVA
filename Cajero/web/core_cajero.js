/* Evento numerico para el input de No. de Tarjeta */
document.addEventListener('DOMContentLoaded', function () {
    var inputElement = document.getElementById('txtNoTarjeta');

    inputElement.addEventListener('input', function (e) {
        let inputValue = e.target.value;

        inputValue = inputValue.replace(/[^0-9]/g, '');
        inputValue = inputValue.slice(0, 4);

        e.target.value = inputValue;
    });
});

/* Evento numerico para el input de NIP */
document.addEventListener('DOMContentLoaded', function () {
    var inputElement = document.getElementById('txtNIP');

    inputElement.addEventListener('input', function (e) {
        let inputValue = e.target.value;

        inputValue = inputValue.replace(/[^0-9]/g, '');
        inputValue = inputValue.slice(0, 4);

        e.target.value = inputValue;
    });
});

/* Evento numerico para el input de Monto */
document.addEventListener('DOMContentLoaded', function () {
    var inputElement = document.getElementById('txtMonto');

    inputElement.addEventListener('input', function (e) {
        let inputValue = e.target.value;

        inputValue = inputValue.replace(/[^0-9]/g, '');
        inputValue = inputValue.slice(0, 16);

        e.target.value = inputValue;
    });
});

function retirar(data) {

    let datos = null;
    let params = null;

    let cajero = {};
    let banco = {};

    cajero.banco = {}; // Inicializar cajero.banco como un objeto
    let bancoNombre = document.getElementById("txtBanco").value;
    console.log(bancoNombre);
    if (bancoNombre === "BBVA") {

        cajero.banco.numeroTarjeta = document.getElementById("txtNoTarjeta").value;
        cajero.cantidad = document.getElementById("txtMonto").value;
        cajero.banco.NIP = document.getElementById("txtNIP").value;
        cajero.nombreBanco = document.getElementById("txtBanco").value;

        datos = {
            datos: JSON.stringify(cajero)
        };

        params = new URLSearchParams(datos);

        console.log(params);
        fetch("api/retiro/validacion",
                {method: "POST",

                    headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                    body: params
                })

                .then(response => {
                    return response.json();
                })
                .then(function (data)
                {
                    console.log(data);
                    if (data.exception != null)
                    {
                        Swal.fire('', data.exception, 'warning');

                        return;
                    }
                    if (data.error != null)
                    {
                        Swal.fire('', data.error, 'warning');

                        return;
                    }
                    if (data.errorperm != null)
                    {
                        Swal.fire('', "No tiene permiso para realizar esta operación.", 'warning');

                    }

                    Swal.fire('', 'Transaccion Exitosa. Recoja su dinero', 'success');

                    //cleanE();
                });
    } else {
        console.log("SI JALA");
        const nombreBanco = document.getElementById("txtBanco").value;
        const numeroTarjeta = document.getElementById("txtNoTarjeta").value;
        const nip = document.getElementById("txtNIP").value;
        const montoRetiro = document.getElementById("txtMonto").value;
        const url = "http://192.168.137.11:8080/Banco/api/banco/validar";

        // Enviar los datos al endpoint REST usando fetch
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
                datosBanco: JSON.stringify({
                    nombreBanco: nombreBanco,
                    numeroTarjeta: numeroTarjeta,
                    nip: nip,
                    montoRetiro: montoRetiro
                })
            })
        })


//        params = new URLSearchParams(datos);
//
//        console.log(params);
//        fetch("http://192.168.137.233:8080/proyectoBanco/api/banco/externoGuardar",
//                {method: "POST",
//
//                    headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
//                    body: params
//                })

                .then(response => {
                    return response.json();
                })
                .then(function (data)
                {
                    console.log(data);
                    if (data.exception != null)
                    {
                        Swal.fire('', data.exception, 'warning');

                        return;
                    }
                    if (data.error != null)
                    {
                        Swal.fire('', data.error, 'warning');

                        return;
                    }
                    if (data.errorperm != null)
                    {
                        Swal.fire('', "No tiene permiso para realizar esta operación.", 'warning');

                    }
                    console.log(data["numeroSeguimiento"]);

                    cajero.idCajero = 1;
                    cajero.cantidad = document.getElementById("txtMonto").value;
                    cajero.codigoRegistro = data.codigo;
                    cajero.banco.NIP = data.nip;
                    cajero.banco.numeroTarjeta = data.numeroTarjeta;

                    datos = {
                        datos: JSON.stringify(cajero)
                    };

                    params = new URLSearchParams(datos);

                    console.log(params);
                    fetch("api/retiro/externo",
                            {method: "POST",

                                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                                body: params
                            })

                            .then(response => {
                                return response.json();
                            })
                            .then(function (data)
                            {
                                console.log(data);
                                if (data.exception != null)
                                {
                                    Swal.fire('', data.exception, 'warning');

                                    return;
                                }
                                if (data.error != null)
                                {
                                    Swal.fire('', data.error, 'warning');

                                    return;
                                }
                                if (data.errorperm != null)
                                {
                                    Swal.fire('', "No tiene permiso para realizar esta operación.", 'warning');

                                }

                                Swal.fire('', 'Transaccion Exitosa. Recoja su dinero', 'success');

                                //cleanE();
                            });

                    //cleanE();
                });
    }
}

