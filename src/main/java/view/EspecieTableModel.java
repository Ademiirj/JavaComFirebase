package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.EspecieModel;

public class EspecieTableModel extends AbstractTableModel {

    private ArrayList<EspecieModel> linhas;
    String[] colunas;
    public EspecieTableModel(ArrayList<EspecieModel> arrayusuario, String[] colunas) {
        this.colunas = colunas;

        linhas = arrayusuario;
    }

    //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        EspecieModel usuario = (EspecieModel) linhas.get(row);
        switch (col) {
            case 0:
                return usuario.getEspecie_simplificado();
            case 1:
                return usuario.getNome();
            case 2:
                return usuario.getCategoria_ameaca(); 
            case 3:
                return usuario.getBioma(); 
            case 4:
                return usuario.getNivel_protecao();
            case 5:
                return usuario.getPrincipais_ameacas();
            case 6:
                return usuario.getFamilia(); 
            case 7:
                return usuario.getFauna_ou_flora();
            case 8:
                return usuario.getGrupo();
            case 9:
                return usuario.getEstados_ocorrencia();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de EspecieModel
    public void addLista(ArrayList<EspecieModel> usuario) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(usuario);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}