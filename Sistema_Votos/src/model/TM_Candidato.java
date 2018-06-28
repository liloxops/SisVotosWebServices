/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Lilo
 */
public class TM_Candidato implements TableModel {

    private List<CandidatoSelect> listCandidatos;

    public TM_Candidato(List<CandidatoSelect> listCandidatos) {
        this.listCandidatos = listCandidatos;
    }

    public CandidatoSelect getCandidato(int index) {
        return listCandidatos.get(index);
    }

    @Override
    public int getRowCount() {
        return listCandidatos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nombre";
            default:
                return "Partido";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CandidatoSelect c = listCandidatos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getNombre();
            default:
                return c.getFk_Partido();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

}
