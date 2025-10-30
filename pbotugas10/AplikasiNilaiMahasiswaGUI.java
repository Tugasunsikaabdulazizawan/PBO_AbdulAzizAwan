import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 

public class AplikasiNilaiMahasiswaGUI extends JFrame {

    private ArrayList<String> dataMahasiswa = new ArrayList<>();

    private JTextField txtNamaLengkap;
    private JTextField txtTugasMurni;
    private JTextField txtNilaiUTS;
    private JTextField txtNilaiUAS;

    private JLabel lblNamaOutput;
    private JLabel lblRataRataOutput;
    private JLabel lblGradeOutput;
    private JLabel lblHasilOutput;

    public AplikasiNilaiMahasiswaGUI() {

        setTitle("AplikasiPenentuNilaiMahasiswa.java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        txtNamaLengkap = new JTextField(20);
        txtTugasMurni = new JTextField(5);
        txtNilaiUTS = new JTextField(5);
        txtNilaiUAS = new JTextField(5);

        lblNamaOutput = new JLabel("nama");
        lblRataRataOutput = new JLabel("rata");
        lblGradeOutput = new JLabel("grade");
        lblHasilOutput = new JLabel("hasil");

        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelHeader.setBackground(new Color(255, 192, 203));
        panelHeader.add(new JLabel("Nama Lengkap"));
        panelHeader.add(txtNamaLengkap);
        add(panelHeader, BorderLayout.NORTH);

        JPanel panelTengah = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel panelInput = new JPanel(new GridLayout(3, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createTitledBorder("Nilai"));
        panelInput.setBackground(new Color(144, 238, 144));
        panelInput.add(new JLabel("Tugas Murni"));
        panelInput.add(txtTugasMurni);
        panelInput.add(new JLabel("Nilai UTS"));
        panelInput.add(txtNilaiUTS);
        panelInput.add(new JLabel("Nilai UAS"));
        panelInput.add(txtNilaiUAS);

        JPanel panelHasil = new JPanel(new GridLayout(4, 2, 5, 5));
        panelHasil.setBorder(BorderFactory.createTitledBorder("Hasil"));
        panelHasil.setBackground(new Color(255, 255, 102));

        panelHasil.add(new JLabel("Nama"));
        panelHasil.add(lblNamaOutput);
        panelHasil.add(new JLabel("Nilai Rata-rata"));
        panelHasil.add(lblRataRataOutput);
        panelHasil.add(new JLabel("Grade"));
        panelHasil.add(lblGradeOutput);
        panelHasil.add(new JLabel("Hasil"));
        panelHasil.add(lblHasilOutput);

        panelTengah.add(panelInput);
        panelTengah.add(panelHasil);
        add(panelTengah, BorderLayout.CENTER);

        JPanel panelKontrol = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelKontrol.setBackground(new Color(173, 216, 230));

        JButton btnHitung = new JButton("Hitung");
        JButton btnBersihkan = new JButton("Bersihkan");
        JButton btnSimpan = new JButton("Simpan");
        JButton btnKeluar = new JButton("Keluar");

        btnHitung.addActionListener(new HitungListener());
        btnBersihkan.addActionListener(new BersihkanListener());
        btnKeluar.addActionListener(e -> System.exit(0)); 
        
        btnSimpan.addActionListener(new SimpanToArrayListListener());

        panelKontrol.add(btnHitung);
        panelKontrol.add(btnBersihkan);
        panelKontrol.add(btnSimpan);
        panelKontrol.add(btnKeluar);
        add(panelKontrol, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double tugas = Double.parseDouble(txtTugasMurni.getText());
                double uts = Double.parseDouble(txtNilaiUTS.getText());
                double uas = Double.parseDouble(txtNilaiUAS.getText());
                String nama = txtNamaLengkap.getText();

                double rataRata = (tugas * 0.2) + (uts * 0.3) + (uas * 0.5);
                String grade;
                String hasil;

                if (rataRata >= 80) {
                    grade = "A";
                    hasil = "LULUS";
                } else if (rataRata >= 70) {
                    grade = "B";
                    hasil = "LULUS";
                } else if (rataRata >= 60) {
                    grade = "C";
                    hasil = "LULUS";
                } else if (rataRata >= 50) {
                    grade = "D";
                    hasil = "TIDAK LULUS";
                } else {
                    grade = "E";
                    hasil = "TIDAK LULUS";
                }

                lblNamaOutput.setText(nama.isEmpty() ? "Nama tidak diisi" : nama);
                lblRataRataOutput.setText(String.format("%.2f", rataRata));
                lblGradeOutput.setText(grade);
                lblHasilOutput.setText(hasil);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(AplikasiNilaiMahasiswaGUI.this, 
                    "Pastikan semua kolom nilai diisi dengan angka!", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                bersihkanOutput();
            }
        }
    }

    private class SimpanToArrayListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = txtNamaLengkap.getText();
            String rataRata = lblRataRataOutput.getText();
            String grade = lblGradeOutput.getText();
            String hasil = lblHasilOutput.getText();

            if (rataRata.equals("rata") || nama.isEmpty()) {
                JOptionPane.showMessageDialog(AplikasiNilaiMahasiswaGUI.this, 
                    "Harap Hitung Nilai dan isi Nama Lengkap terlebih dahulu.", 
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String dataBaru = String.format("Nama: %s | Rata: %s | Grade: %s | Hasil: %s", 
                                            nama, rataRata, grade, hasil);
            
            dataMahasiswa.add(dataBaru);
            
            System.out.println("  RIWAYAT DATA MAHASISWA (Total: " + dataMahasiswa.size() + " data)");
            
            for (int i = 0; i < dataMahasiswa.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + dataMahasiswa.get(i));
            }

            JOptionPane.showMessageDialog(AplikasiNilaiMahasiswaGUI.this, 
                "Data nilai " + nama + " berhasil disimpan ke memori dan dicetak ke Terminal!", 
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class BersihkanListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtNamaLengkap.setText("");
            txtTugasMurni.setText("");
            txtNilaiUTS.setText("");
            txtNilaiUAS.setText("");
            
            bersihkanOutput();
        }
    }
    
    private void bersihkanOutput() {
        lblNamaOutput.setText("nama");
        lblRataRataOutput.setText("rata");
        lblGradeOutput.setText("grade");
        lblHasilOutput.setText("hasil");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AplikasiNilaiMahasiswaGUI());
    }
}