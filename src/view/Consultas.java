/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cadastroempresas.retrofit.repository_retrofit.CityRepository;
import cadastroempresas.retrofit.repository_retrofit.CompanhiaRepository;
import cadastroempresas.retrofit.repository_retrofit.NeighborhoodRepository;
import cadastroempresas.retrofit.repository_retrofit.StateRepository;
import cadastroempresas.retrofit.service_retrofit.Retrofit_URL;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.City;
import model.Company;
import model.Neighborhood;
import model.State;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author helde
 */
public class Consultas extends javax.swing.JFrame {

    static String entidadeUtilizada, STATUS_FORM;

    Retrofit_URL retrofit = new Retrofit_URL();

    StateRepository BaseURL_estados = retrofit.BaseURL().create(StateRepository.class);
    CityRepository BaseURL_cidades = retrofit.BaseURL().create(CityRepository.class);
    NeighborhoodRepository BaseURL_neighborhood = retrofit.BaseURL().create(NeighborhoodRepository.class);
    CompanhiaRepository BaseURL_companhia = retrofit.BaseURL().create(CompanhiaRepository.class);

    public Consultas() {
        initComponents();

        addWindowListener(new WindowAdapter() { // para confirna se deseja ralmente fechar a janela
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Sim", "Não"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Deseja realmente fechar essa janela de consultas?", "ATENÇÃO",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    Home h = new Home();
                    h.habilitarForm();
                    Consultas.this.dispose();
                }
            }
        });
    }

    public void statusForm(String entidade, String status) {
        entidadeUtilizada = entidade;
        STATUS_FORM = status;
    }

    public void getEstados() {
        Call<List<State>> callState = BaseURL_estados.getStatesCadastrados();
        callState.enqueue(new Callback<List<State>>() {
            @Override
            public void onResponse(Call<List<State>> call, Response<List<State>> rspns) {
                if (rspns.isSuccessful()) {
                    List<State> states = rspns.body();
                    listarTabela_estados(states);
                    callState.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<State>> call, Throwable thrwbl) {
            }
        });
    }

    public void getEstados_name(String nome) {
        Call<List<State>> callState = BaseURL_estados.getStatesCadastrados_name(nome);
        callState.enqueue(new Callback<List<State>>() {
            @Override
            public void onResponse(Call<List<State>> call, Response<List<State>> rspns) {
                if (rspns.isSuccessful()) {
                    List<State> states = rspns.body();
                    listarTabela_estados(states);
                    callState.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<State>> call, Throwable thrwbl) {
            }
        });
    }

    public void getCidades() {
        Call<List<City>> callCity = BaseURL_cidades.getCitysCadastrados();
        callCity.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> rspns) {
                if (rspns.isSuccessful()) {
                    List<City> citys = rspns.body();
                    listarTabela_cidades(citys);
                    callCity.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable thrwbl) {
            }
        });
    }

    public void getCidades_name(String nome) {
        Call<List<City>> callCity = BaseURL_cidades.getCitysCadastrados_name(nome);
        callCity.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> rspns) {
                if (rspns.isSuccessful()) {
                    List<City> citys = rspns.body();
                    listarTabela_cidades(citys);
                    callCity.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable thrwbl) {
            }
        });
    }

    public void getVizinhancas() {
        Call<List<Neighborhood>> callState = BaseURL_neighborhood.getNeighborhoodCadastrados();
        callState.enqueue(new Callback<List<Neighborhood>>() {
            @Override
            public void onResponse(Call<List<Neighborhood>> call, Response<List<Neighborhood>> rspns) {
                if (rspns.isSuccessful()) {
                    List<Neighborhood> neighborhoods = rspns.body();
                    listarTabela_vizinhancas(neighborhoods);
                    callState.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<Neighborhood>> call, Throwable thrwbl) {
            }
        });
    }

    public void getVizinhancas_name(String name) {
        Call<List<Neighborhood>> callState = BaseURL_neighborhood.getNeighborhoodCadastrados_name(name);
        callState.enqueue(new Callback<List<Neighborhood>>() {
            @Override
            public void onResponse(Call<List<Neighborhood>> call, Response<List<Neighborhood>> rspns) {
                if (rspns.isSuccessful()) {
                    List<Neighborhood> neighborhoods = rspns.body();
                    listarTabela_vizinhancas(neighborhoods);
                    callState.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<Neighborhood>> call, Throwable thrwbl) {
            }
        });
    }

    public void getCompanhias() {
        Call<List<Company>> callState = BaseURL_companhia.getCompanys();
        callState.enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, Response<List<Company>> rspns) {
                if (rspns.isSuccessful()) {
                    List<Company> companys = rspns.body();
                    listarTabela_companhia(companys);
                    callState.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<Company>> call, Throwable thrwbl) {
            }
        });
    }

    public void getCompanhias_name(String name) {
        Call<List<Company>> callState = BaseURL_companhia.getCompanys_name(name);
        callState.enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, Response<List<Company>> rspns) {
                if (rspns.isSuccessful()) {
                    List<Company> companys = rspns.body();
                    listarTabela_companhia(companys);
                    callState.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<Company>> call, Throwable thrwbl) {
            }
        });
    }
//---------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------LISTAR TABELA-------------------------------------------------------------------------------------------

    private void listarTabela_estados(List<State> states) {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(180);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0); // OCULTA A COLUNA (ID) DA TABELA PARA NÃO APARECER PARA O USUARIO
        states.forEach((s) -> {
            dtma.addRow(new Object[]{
                s.getId(),
                s.getName()
            });
        });
        corLinhaTabelaAnuidade(TABELA);
        TABELA.getTableHeader().setReorderingAllowed(false);
    }

    private void listarTabela_cidades(List<City> citys) {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(190);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0);
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0);
        citys.forEach((s) -> {
            dtma.addRow(new Object[]{
                s.getId(),
                s.getName()
            });
        });
        corLinhaTabelaAnuidade(TABELA);
        TABELA.getTableHeader().setReorderingAllowed(false);
    }

    private void listarTabela_vizinhancas(List<Neighborhood> neighborhoods) {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(190);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0);
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0);
        neighborhoods.forEach((s) -> {
            dtma.addRow(new Object[]{
                s.getId(),
                s.getName()
            });
        });
        corLinhaTabelaAnuidade(TABELA);
        TABELA.getTableHeader().setReorderingAllowed(false);
    }

    private void listarTabela_companhia(List<Company> companys) {
        DefaultTableModel dtma = (DefaultTableModel) TABELA.getModel();
        dtma.setNumRows(0);
        TABELA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TABELA.getColumnModel().getColumn(1).setPreferredWidth(190);

        TABELA.getColumnModel().getColumn(0).setMinWidth(0);
        TABELA.getColumnModel().getColumn(0).setMaxWidth(0);
        companys.forEach((s) -> {
            dtma.addRow(new Object[]{
                s.getId(),
                s.getCorporateName()
            });
        });
        corLinhaTabelaAnuidade(TABELA);
        TABELA.getTableHeader().setReorderingAllowed(false);
    }

    private void corLinhaTabelaAnuidade(JTable tabela) {
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (row % 2 != 0) {
                    setBackground(Color.BLUE);
                } else {
                    setBackground(Color.GRAY);
                }
                return this;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABELA = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        TABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABELA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABELAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABELA);
        if (TABELA.getColumnModel().getColumnCount() > 0) {
            TABELA.getColumnModel().getColumn(0).setResizable(false);
            TABELA.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("Nome:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        switch (entidadeUtilizada) {
            case "estado":
                if (!txtNome.getText().equals("")) {
                    getEstados_name(txtNome.getText());
                } else {
                    getEstados();
                }
                break;
            case "cidade":
                if (!txtNome.getText().equals("")) {
                    getCidades_name(txtNome.getText());
                } else {
                    getCidades();
                }
                break;
            case "vizinhanca":
                if (!txtNome.getText().equals("")) {
                    getVizinhancas_name(txtNome.getText());
                } else {
                    getVizinhancas();
                }
                break;
            case "companhia":
                if (!txtNome.getText().equals("")) {
                    getCompanhias_name(txtNome.getText());
                } else {
                    getCompanhias();
                }
                break;
            default:
                break;
        }


    }//GEN-LAST:event_jLabel3MouseClicked

    private void TABELAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELAMouseClicked
        if (entidadeUtilizada.equals("companhia") && STATUS_FORM.equals("alterar")) {
            long id = Long.parseLong(TABELA.getValueAt(TABELA.getSelectedRow(), 0).toString());
            Call<Company> callState = BaseURL_companhia.getCompany_detalhada(id);
            callState.enqueue(new Callback<Company>() {
                @Override
                public void onResponse(Call<Company> call, Response<Company> rspns) {
                    if (rspns.isSuccessful()) {
                        Company company = rspns.body();

                        Companhia c = new Companhia();
                        c.statusForm("alterar");
                        c.setTitle("Alterar Companhia");
                        c.preencherCampusLocalizacao(company);
                        c.setVisible(true);
                        Consultas.this.setVisible(false);
                    }
                }

                @Override
                public void onFailure(Call<Company> call, Throwable thrwbl) {
                }
            });
        }
    }//GEN-LAST:event_TABELAMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABELA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
