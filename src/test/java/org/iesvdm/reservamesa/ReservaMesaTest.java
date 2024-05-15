package org.iesvdm.reservamesa;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class ReservaMesaTest {



    // test de cada elemento
    //master


    @Test
    void rellenarmesa(){

        ReservaMesa mesa = new ReservaMesa();

        int tamanioMesa = 4;
        int [] mesas = new int [tamanioMesa];

        mesa.setTamanioMesa(tamanioMesa);
        mesa.setMesas(mesa.getMesas());

        for (int i = 0; i < mesas.length; i++)
        {
            int aleatorio = (int) (Math.random() * tamanioMesa+1);

            mesas[i]= aleatorio;
        }

        assertThat(mesas.length).isEqualTo(tamanioMesa);



    }

    @Test
    void imprimir() {
        ReservaMesa mesa = new ReservaMesa();
        int tamanioMesa = 4;
        int[] mesas = new int[tamanioMesa];

        mesa.setTamanioMesa(tamanioMesa);
        mesa.setMesas(mesas);
        mesa.rellenarMesas();
        mesa.imprimir();

        assertThat(mesa.getTamanioMesa()).isEqualTo(tamanioMesa);

    }

    @Test
    void buscarPrimeraMesaVacia() {

        ReservaMesa mesa = new ReservaMesa();
        int tamanioMesa = 4;

        int[] mesas = new int[tamanioMesa];
        mesa.setTamanioMesa(tamanioMesa);
        mesa.setMesas(mesas);

        mesa.buscarPrimeraMesaVacia();
        assertThat(mesa.buscarPrimeraMesaVacia()).isEqualTo(0);

    }

    @Test
    void BuscarMesaCompartirMasCercaDe(){

        ReservaMesa mesa = new ReservaMesa();
        int tamanioMesa = 4;


        int[] mesas = new int[tamanioMesa];
        mesa.setTamanioMesa(tamanioMesa);
        mesa.setMesas(mesas);
        mesa.rellenarMesas();

        mesa.buscarMesaCompartirMasCercaDe(1,2);

        assertThat(mesa.buscarMesaCompartirMasCercaDe(1,2)).isEqualTo(1);

    }

    @Test
    void buscarMesaCompartirMasAlejadaDe(){
        ReservaMesa mesa = new ReservaMesa();
        int tamanioMesa = 4;

        int[] mesas = new int[tamanioMesa];
        mesa.setTamanioMesa(tamanioMesa);
        mesa.setMesas(mesas);
        mesa.rellenarMesas();
        mesa.buscarMesaCompartirMasAlejadaDe(3,1);

        assertThat(mesa.buscarMesaCompartirMasCercaDe(3,1)).isEqualTo(3);
    }

    @Test
    void buscarCompartirNMesasConsecutivas(){
        ReservaMesa mesa = new ReservaMesa();
        int tamanioMesa = 4;
        int[] mesas = new int[tamanioMesa];
        mesa.setTamanioMesa(tamanioMesa);
        mesa.setMesas(mesas);
        mesa.rellenarMesas();
        mesa.buscarCompartirNMesasConsecutivas(2,2);

        assertThat(mesa.buscarCompartirNMesasConsecutivas(2,2)).isEqualTo(0);
    }

    @Test
    void comensalesTotales(){
        ReservaMesa mesa = new ReservaMesa();
        int tamanioMesa = 4;
        int[] mesas = new int[tamanioMesa];
        mesa.setTamanioMesa(tamanioMesa);
        mesa.setMesas(mesas);
        mesa.rellenarMesas();
        mesa.comensalesTotales();
        for (int i = 0; i < mesas.length; i++)
        {
            int aleatorio = (int) (Math.random() * tamanioMesa+1);

            mesas[i]= aleatorio;
        }

        assertThat(mesa.comensalesTotales()).isEqualTo(10);



    }


}



