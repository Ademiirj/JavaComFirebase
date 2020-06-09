package view;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.NonNull;
import com.google.gson.Gson;
import static conexao.Conexao.initFirebase;
import java.awt.Dimension;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.EspecieModel;

public class UsuarioView extends javax.swing.JFrame {

    int teste = 0;
    boolean entrouNoNome;
    private String colunas[] = {"Especie", "Nome", "Cat Ameaça", "Bioma", "Nivel Prot", "Ameaças", "Familia", "Fauna/Flora", "Grupo", "UF"};
    private ArrayList<EspecieModel> lista = new ArrayList<>();
    private ArrayList<EspecieModel> listaConsulta = new ArrayList<>();
    private EspecieTableModel tabelaFiltrada;
    static EspecieModel especieModel;
    private DatabaseReference usuariosFirebase;

    public UsuarioView() {

        initComponents();
        this.setPreferredSize(new Dimension(1024,1060));
        setLocationRelativeTo(null);

        // adiciona evento para qdo navegar no JTable, atualizar os dados nos JTextFieldÂ´s
        tblConsulta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = tblConsulta.getSelectedRow();
                if (selecionado >= 0) {
                    mostrar(lista.get(selecionado));
                }
            }
        });
        setVisible(true);

        JOptionPane.showMessageDialog(new JFrame(), "Para iniciar, conecte ao banco de dados");

        lblMensagem.setText("Conexão necessária");
        pack();
    }
    public static String Formata(String str) {
    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelDADOS = new javax.swing.JPanel();
        lblUSU_NOME = new javax.swing.JLabel();
        lblUSU_LOGIN = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_categoriaAmeaca = new javax.swing.JTextField();
        txt_bioma = new javax.swing.JTextField();
        lblUSU_LOGIN1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cb_fauna = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cb_grupo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cb_familia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_especie = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_ameacas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cb_uf = new javax.swing.JComboBox<>();
        btnConsulta = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        painelCONSULTA = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        lblMensagem = new javax.swing.JLabel();
        btnSAIR = new javax.swing.JButton();
        btn_Sincronizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MVC - Cadastro de Usuários");
        setFocusable(false);
        setPreferredSize(new java.awt.Dimension(1024, 900));
        getContentPane().setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("Cadastro de Usuários Firebase");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(40, 80, 460, 29);

        lblUSU_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_NOME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUSU_NOME.setText("Nome");

        lblUSU_LOGIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_LOGIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUSU_LOGIN.setText("Categoria da Ameaca");

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        txt_categoriaAmeaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_bioma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblUSU_LOGIN1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_LOGIN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUSU_LOGIN1.setText("Bioma");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fauna/Flora");

        cb_fauna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Fauna", "Flora" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Grupo");

        cb_grupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Angiospermas", "Aves", "Invertebrados Terrestres", "Peixes Marinhos", "Anfíbios", "Pteridófitas", "Invertebrados Aquáticos", "Peixes Continentais", "Mamíferos", "Répteis", "Gimnospermas", "Briófitas" }));
        cb_grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_grupoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Familia");

        cb_familia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Salicaceae", "Cracidae", "Malvaceae", "Santalaceae", "Myrtaceae", "Coenagrionidae", "Hypogastruridae", "Plantaginaceae", "Achiridae", "Orchidaceae", "Asteraceae", "Furnariidae", "Arecaceae", "Eriocaulaceae", "Nymphalidae", "Baetidae", "Eleutherodactylidae", "Bignoniaceae", "Euphorbiaceae", "Pteridaceae", "Bromeliaceae", "Aeglidae", "Fabaceae", "Orobanchaceae", "Hylidae", "Poaceae", "Pimelodidae", "Lauraceae", "Cricetidae", "Polypodiaceae", "Tyrannidae", "Sphingidae", "Aromobatidae", "Rutaceae", "Alopiidae", "Atelidae", "Verbenaceae", "Rubiaceae", "Alstroemeriaceae", "Amaranthaceae", "Lucanidae", "Accipitridae", "Psittacidae", "Teiidae", "Typhlopidae", "Amphisbanidae", "Lampyridae", "Rivulidae", "Buthidae", "Loricariidae", "Anemiaceae", "Annonaceae", "Formicidae", "Araceae", "Motacillidae", "Pipridae", "Loasaceae", "Parodontidae", "Acanthaceae", "Characidae", "Dipsadidae", "Apteronotidae", "Araucariaceae", "Lycaenidae", "Andrenidae", "Aristolochiaceae", "Passerelidae", "Arrhopalitidae", "Cactaceae", "Aspleniaceae", "Cyclanthaceae", "Astropectinidae", "Canidae", "Scarabaeidae", "Arhynchobatidae", "Dicranaceae", "Trochilidae", "Theraphosidae", "Gymnophthalmidae", "Balaenopteridae", "Malpighiaceae", "Velloziaceae", "Begoniaceae", "Berberidaceae", "Lecythidaceae", "Melastomataceae", "Gesneriaceae", "Cervidae", "Blechnaceae", "Lejeuneaceae", "Plethodontidae", "Calyceraceae", "Viperidae", "Bouchardiidae", "Brachycephalidae", "Hypopomidae", "Bradypodidae", "Mabuyidae", "Prodidomidae", "Hedwigiaceae", "Combretaceae", "Scrophulariaceae", "Cyperaceae", "Burseraceae", "Pitheciidae", "Solanaceae", "Scolopacidae", "Vochysiaceae", "Echimyidae", "Callitrichidae", "Didelphidae", "Platyrinchidae", "Dendrocolaptidae", "Capitonidae", "Carcharhinidae", "Odontaspididae", "Lamnidae", "Gecarcinidae", "Cheloniidae", "Cotingidae", "Lycidae", "Cardinalidae", "Cassidulidae", "Simaroubaceae", "Aeshnidae", "Caviidae", "Cebidae", "Meliaceae", "Ctenidae", "Picidae", "Ciidae", "Thamnophilidae", "Microdesmidae", "Cetorhinidae", "Erethizontidae", "Formicariidae", "Crenuchidae", "Charadriidae", "Charinidae", "Pieridae", "Heptapteridae", "Microhylidae", "Oleaceae", "Serranidae", "Dithrichaceae", "Sapotaceae", "Turdidae", "Vitaceae", "Columbidae", "Clusiaceae", "Poeciliidae", "Carabidae", "Sphaerodactylidae", "Rhamnaceae", "Actiniidae", "Conopophagidae", "Thraupidae", "Dytiscidae", "Boidae", "Metaniidae", "Callichthyidae", "Asteriidae", "Chrysobalanaceae", "Crassulaceae", "Cichlidae", "Hylodidae", "Cryptopidae", "Tinamidae", "Ctenomyidae", "Sapindaceae", "Lythraceae", "Icteridae", "Lamiaceae", "Corvidae", "Cycloramphidae", "Dactyloidae", "Dasyatidae", "Dilleniaceae", "Dermochelydae", "Commelinaceae", "Dicksoniaceae", "Diomedeidae", "Onuphidae", "Chelodesmidae", "Dioscoreaceae", "Lycopodiaceae", "Hyriidae", "Saturniidae", "Apocynaceae", "Moraceae", "Hesperiidae", "Droseraceae", "Drymusidae", "Sternopygidae", "Amaryllidaceae", "Gobiidae", "Dryopteridaceae", "Libellulidae", "Rhinocryptidae", "Tripterygiidae", "Leiosauridae", "Ephedraceae", "Epinephelidae", "Peripatidae", "Vespertilionidae", "Apiaceae", "Erythroxylaceae", "Escalloniaceae", "Balaenidae", "Eukoeneniidae", "Eunicidae", "Proteaceae", "Gonyleptidae", "Strombidae", "Pectinidae", "Convolvulaceae", "Glossoscolecidae", "Fregatidae", "Furipteridae", "Triakidae", "Ericaceae", "Ariidae", "Lentibulariaceae", "Scleruridae", "Ginglymostomatidae", "Trichomycteridae", "Glomerodesmidae", "Phyllostomidae", "Marantaceae", "Arnelliaceae", "Strophocheilidae", "Grallariidae", "Gunneraceae", "Gymnuridae", "Chactidae", "Labridae", "Halichondriidae", "Dipluridae", "Doradidae", "Cistaceae", "Rhynchocyclidae", "Papilionidae", "Leptophlebiidae", "Heteragrionidae", "Syngnathidae", "Craugastoridae", "Phyllodactylidae", "Humiriaceae", "Violaceae", "Araliaceae", "Caprimulgidae", "Vireonidae", "Hymenophyllaceae", "Hypericaceae", "Vesperidae", "Anostomidae", "Streptaxidae", "Corinnidae", "Ideoroncidae", "Aquifoliaceae", "Iniidae", "Tityridae", "Myristicaceae", "Isoetaceae", "Isotomidae", "Pallaviciniaceae", "Anablepidae", "Riodinidae", "Jungermanniaceae", "Istiophoridae", "Calophyllaceae", "Latrunculiidae", "Lebiasinidae", "Felidae", "Pottiaceae", "Ophidiasteridae", "Linaceae", "Liolaemidae", "Campanulaceae", "Pseudopimelodidae", "Malacanthidae", "Luidiidae", "Lutjanidae", "Ochnaceae", "Lymnaeidae", "Primulaceae", "Toxopneustidae", "Odontostomidae", "Monimiaceae", "Labrisomidae", "Mobulidae", "Marchantiaceae", "Salticidae", "Chernetidae", "Celastraceae", "Megalobulimidae", "Megalopidae", "Bufonidae", "Apidae", "Anatidae", "Chelidae", "Pholcidae", "Metzgeriaceae", "Pomacentridae", "Phytolaccaceae", "Milleporidae", "Momotidae", "Bucconidae", "Gelsemiaceae", "Podostemaceae", "Mussidae", "Mycetopodidae", "Serrasalmidae", "Myliobatidae", "Anacardiaceae", "Myrmecophagidae", "Myxinidae", "Natalidae", "Cuculidae", "Hexanchidae", "Nyctibiidae", "Ochyroceratidae", "Atherinopsidae", "Odontophoridae", "Olividae", "Ophidiidae", "Oreasteridae", "Oxalidaceae", "Lepidoziaceae", "Pyralidae", "Sminthuridae", "Leptodactylidae", "Potamotrygonidae", "Passifloraceae", "Piperaceae", "Cryptodesmidae", "Vermetidae", "Phaethontidae", "Phyllanthaceae", "Veronicellidae", "Gomphidae", "Physidae", "Physeteridae", "Picramniaceae", "Urticaceae", "Pipritidae", "Plagiochilaceae", "Planorbidae", "Podocarpaceae", "Sciaenidae", "Polygalaceae", "Polyprionidae", "Ampullariidae", "Pontoporiidae", "Portulacaceae", "Rallidae", "Batrachoididae", "Hydrobiidae", "Gentianaceae", "Bruchiaceae", "Dasypodidae", "Pristidae", "Procellariidae", "Odontophrynidae", "Prochilodontidae", "Olpiidae", "Chaetodontidae", "Chthoniidae", "Spirostreptidae", "Iridaceae", "Psophiidae", "Ramphastidae", "Mustelidae", "Strigidae", "Quillajaceae", "Spongillidae", "Marsileaceae", "Zingiberaceae", "Rhincodontidae", "Rhinobatidae", "Ricciaceae", "Cynodontidae", "Connaraceae", "Hubbardiidae", "Alismataceae", "Scolopendridae", "Scorpaenidae", "Selaginellaceae", "Elaeocarpaceae", "Smilacaceae", "Delphinidae", "Escadabiidae", "Bochicidae", "Sphyrnidae", "Loganiaceae", "Cryptogeobiidae", "Pomatiopsidae", "Fringilidae", "Squalidae", "Squatinidae", "Tropiduridae", "Dichapetalaceae", "Sternidae", "Succineidae", "Sulidae", "Symplocaceae", "Synaptidae", "Tapiriidae", "Tayassuidae", "Pentaphylacaceae", "Bulimulidae", "Thelypteridaceae", "Scombridae", "Ardeidae", "Torpedinidae", "Trichechidae", "Trigoniaceae", "Paronellidae", "Trogonidae", "Tropaeolaceae", "Tropidophiidae", "Caprifoliaceae", "Spengelidae", "Xenopidae", "Xyridaceae", "Pyrgodesmidae" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Especie");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Principais Ameças");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("UF");

        cb_uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UF", "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF" }));

        btnConsulta.setText("Pesquisar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDADOSLayout = new javax.swing.GroupLayout(painelDADOS);
        painelDADOS.setLayout(painelDADOSLayout);
        painelDADOSLayout.setHorizontalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ameacas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_categoriaAmeaca)
                            .addComponent(lblUSU_LOGIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUSU_NOME, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(txt_nome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_fauna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_grupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cb_familia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_especie, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addComponent(lblUSU_LOGIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addComponent(txt_bioma, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))))
                .addGap(99, 99, 99))
        );
        painelDADOSLayout.setVerticalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_fauna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(lblUSU_LOGIN1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_familia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_bioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsulta))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addComponent(lblUSU_LOGIN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_categoriaAmeaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                        .addComponent(lblUSU_NOME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ameacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimpar)
                            .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addGroup(painelDADOSLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados do Usuário", painelDADOS);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 110, 980, 170);

        jScrollPane2.setViewportView(tblConsulta);

        javax.swing.GroupLayout painelCONSULTALayout = new javax.swing.GroupLayout(painelCONSULTA);
        painelCONSULTA.setLayout(painelCONSULTALayout);
        painelCONSULTALayout.setHorizontalGroup(
            painelCONSULTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCONSULTALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelCONSULTALayout.setVerticalGroup(
            painelCONSULTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Consulta", painelCONSULTA);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(10, 290, 980, 330);

        jToolBar2.setRollover(true);

        lblMensagem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(0, 0, 255));
        lblMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensagem.setText("Mensagem");
        lblMensagem.setFocusable(false);
        jToolBar2.add(lblMensagem);

        getContentPane().add(jToolBar2);
        jToolBar2.setBounds(0, 660, 1080, 30);

        btnSAIR.setText("Fechar");
        btnSAIR.setFocusable(false);
        btnSAIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSAIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAIRActionPerformed(evt);
            }
        });
        getContentPane().add(btnSAIR);
        btnSAIR.setBounds(860, 20, 100, 30);

        btn_Sincronizar.setText("SINCRONIZAR");
        btn_Sincronizar.setFocusable(false);
        btn_Sincronizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Sincronizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Sincronizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SincronizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Sincronizar);
        btn_Sincronizar.setBounds(350, 10, 130, 50);

        jButton1.setText("CONECTAR");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(103, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(103, 23));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 10, 130, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparAgenda() {
        cb_fauna.setSelectedIndex(0);
        cb_grupo.setSelectedIndex(0);
        cb_familia.setSelectedIndex(0);
        cb_uf.setSelectedIndex(0);
        txt_nome.setText("");
        txt_categoriaAmeaca.setText("");
        txt_bioma.setText("");
        txt_especie.setText("");
        txt_ameacas.setText("");
    }

    private void mostrar(EspecieModel usuario) {
        txt_nome.setText(usuario.getNome());
        txt_categoriaAmeaca.setText(usuario.getCategoria_ameaca());
        txt_bioma.setText(usuario.getBioma());
        txt_especie.setText(usuario.getEspecie_simplificado());
        txt_ameacas.setText(usuario.getPrincipais_ameacas());
    }

    private void filtroConsulta() {
        listaConsulta.clear();
        String bioma = Formata(txt_bioma.getText().toLowerCase().trim());
        String nome = Formata(txt_nome.getText().toLowerCase().trim());
        String especie = Formata(txt_especie.getText().toLowerCase().trim());
        String ameacas = Formata(txt_ameacas.getText().toLowerCase().trim());
        String categoriaAmeaca = Formata(txt_categoriaAmeaca.getText().toLowerCase().trim());

        String faunaFlora = (String) cb_fauna.getSelectedItem();
        String grupo = (String) cb_grupo.getSelectedItem();
        String familia = (String) cb_familia.getSelectedItem();
        String uf = (String) cb_uf.getSelectedItem();
        grupo = grupo.replace("í", "i");
        boolean teste = true;
        
        for (int i = 0; i < lista.size(); i++) {
            teste = true;

            if (!bioma.equals("")) {
                if (!Formata(lista.get(i).getBioma().trim().toLowerCase()).equals(bioma)) {
                    teste = false;
                }
            }
            if (!nome.equals("")) {
                if (!Formata(lista.get(i).getNome().trim().toLowerCase()).equals(nome)) {
                    teste = false;
                }
            }
            if (!especie.equals("")) {
                if (!Formata(lista.get(i).getEspecie_simplificado().trim().toLowerCase()).equals(especie)) {
                    teste = false;
                }
            }
            if (!categoriaAmeaca.equals("")) {
                if (!Formata(lista.get(i).getCategoria_ameaca().trim().toLowerCase()).equals(categoriaAmeaca)) {
                    teste = false;
                }
            }
            if (!faunaFlora.equals("Selecionar")) {
                if (!lista.get(i).getFauna_ou_flora().equals(faunaFlora)) {
                    teste = false;
                }
            }

            if (!grupo.equals("Selecionar")) {
                if (!lista.get(i).getGrupo().equals(grupo)) {
                    teste = false;
                }
            }

            if (!familia.equals("Selecionar")) {
                if (!lista.get(i).getFamilia().equals(familia)) {
                    teste = false;
                }
            }
            if (!uf.equals("UF")) {
                String[] ufs = lista.get(i).getEstados_ocorrencia().split(";");
                boolean encontrouUf = false;
                for (String ufl : ufs) {
                    String ufCompara = ufl.replace(" ", "");
                    if (ufCompara.equals(uf)) {
                        encontrouUf = true;
                    }
                }
                if (!encontrouUf) {
                    teste = false;
                }
            }
            
            if (!ameacas.equals("")) {
                String[] ameacasArray = lista.get(i).getPrincipais_ameacas().split(";");
                boolean encontrouAmeaca = false;
                for (String ameacaL : ameacasArray) {
                    String ameacaCompara = ameacaL.replace(" ", "").toLowerCase();
                    if (ameacaCompara.equals(ameacas)) {
                        encontrouAmeaca = true;
                    }
                }
                if (!encontrouAmeaca) {
                    teste = false;
                }
            }
            if (teste) {
                listaConsulta.add(lista.get(i));
            }
        }

        tabelaFiltrada = new EspecieTableModel(listaConsulta, colunas);
        tblConsulta.setModel(tabelaFiltrada);
        tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void consultar() {
        lblMensagem.setText("Por favor aguarde, consultando dados...");

        try {
            usuariosFirebase.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    lista.clear();

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        EspecieModel user = ds.getValue(EspecieModel.class);
                        lista.add(user);
                    }
                    tabelaFiltrada = new EspecieTableModel(lista, colunas);
                    tblConsulta.setModel(tabelaFiltrada);
                    tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    lblMensagem.setText("");
                }
                
                @Override
                public void onCancelled(DatabaseError e) {
                    JOptionPane.showMessageDialog(null, "Consulta Cancelada \n" + e.getMessage());
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta do Usuário \n" + e.getMessage());
        }

    }

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        filtroConsulta();
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAIRActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSAIRActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparAgenda();
        consultar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void cb_grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_grupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_grupoActionPerformed

    private void btn_SincronizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SincronizarActionPerformed
        try {
            ArrayList<EspecieModel> listaSincroniza = new ArrayList<>();

            Gson gson = new Gson();
            String jsonString = String.join(" ", Files.readAllLines(Paths.get("./especies.json"), StandardCharsets.UTF_8));

            EspecieModel[] especieArray = gson.fromJson(jsonString, EspecieModel[].class);

            for (EspecieModel especieArray1 : especieArray) {
                try {
                    EspecieModel especie = new EspecieModel();
                    especie.setCategoria_ameaca(especieArray1.getCategoria_ameaca());
                    especie.setEspecie_simplificado(especieArray1.getEspecie_simplificado());
                    especie.setBioma(especieArray1.getBioma());
                    especie.setFamilia(especieArray1.getFamilia());
                    especie.setFauna_ou_flora(especieArray1.getFauna_ou_flora());
                    especie.setGrupo(especieArray1.getGrupo());
                    especie.setNome(especieArray1.getNome());
                    especie.setPrincipais_ameacas(especieArray1.getPrincipais_ameacas());
                    especie.setSigla_categoria_ameaca(especieArray1.getSigla_categoria_ameaca());
                    especie.setAreas_protegidas(especieArray1.getAreas_protegidas());
                    especie.setPlano_conservacao(especieArray1.getPlano_conservacao());
                    especie.setOrdenamento_pesqueiro(especieArray1.getOrdenamento_pesqueiro());
                    especie.setNivel_protecao(especieArray1.getNivel_protecao());
                    especie.setExclusiva_brasil(especieArray1.getExclusiva_brasil());
                    especie.setEstados_ocorrencia(especieArray1.getEstados_ocorrencia());

                    listaSincroniza.add(especie);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro na Gravação \n" + ex.getMessage());
                }
            }
            usuariosFirebase.child("").setValue(listaSincroniza, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    lblMensagem.setText("Dados Gravados com Sucesso");
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_SincronizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        initFirebase();
        usuariosFirebase = FirebaseDatabase.getInstance().getReference().child("");
        consultar();
        lblMensagem.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JButton btn_Sincronizar;
    private javax.swing.JComboBox<String> cb_familia;
    private javax.swing.JComboBox<String> cb_fauna;
    private javax.swing.JComboBox<String> cb_grupo;
    private javax.swing.JComboBox<String> cb_uf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUSU_LOGIN;
    private javax.swing.JLabel lblUSU_LOGIN1;
    private javax.swing.JLabel lblUSU_NOME;
    private javax.swing.JPanel painelCONSULTA;
    private javax.swing.JPanel painelDADOS;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTextField txt_ameacas;
    private javax.swing.JTextField txt_bioma;
    private javax.swing.JTextField txt_categoriaAmeaca;
    private javax.swing.JTextField txt_especie;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables
}
