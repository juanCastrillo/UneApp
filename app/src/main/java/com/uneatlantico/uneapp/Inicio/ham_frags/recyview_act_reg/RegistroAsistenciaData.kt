package com.uneatlantico.uneapp.Inicio.ham_frags.recyview_act_reg

class RegistroAsistenciaData {
   /* //companion object {

    var db: kotlin.collections.ArrayList<Registro>
    lateinit var idEvento: Array<Long>
    lateinit var fecha: Array<String>
    constructor(){
        db = RegistrosDataBase(RegistroAsistenciaActivity()).recogerAllRegistros()
        getRegistros()
        /*idEvento = idEvento()
        fecha = fecha()*/

    }

    private fun getRegistros() {
        //lateinit var temp1: Array<Long>
        //lateinit var temp2: Array<String>
        var i= 0
        db.forEach {
            idEvento[i] = it.idEvento
            fecha[i] = it.fecha
            i++
        }
    }
        /*fun idEvento(): Array<Long> {
            val temp1 = RegistrosDataBase(RegistroAsistenciaActivity()).recogerAllRegistros()
            var i = 0
            temp1.forEach {
                idEvento[i] = it.idEvento
                i++
            }
            return idEvento
        }

        fun fecha(): Array<String> {
            val temp1 = RegistrosDataBase(RegistroAsistenciaActivity()).recogerAllRegistros()
            var i = 0
            temp1.forEach {
                fecha[i] = it.fecha
                i++
            }
            return fecha
        }*/

    /*var idEvento = arrayOf(1, 2, 3, 4, 5)


        var fecha = arrayOf("Uno", "dos", "tres", "cuatro", "cinco")
    //}*/*/
}