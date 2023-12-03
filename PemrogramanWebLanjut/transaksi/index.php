<?php
session_start();

$_SESSION['title'] = 'Daftar Transaksi';
$_SESSION['sidebar'] = 'daftar transaksi';

include('../config/proses.php');

if(isset($_GET['delete'])){
    $db->delete("paket", "id = {$_GET['delete']}");
    header('Location: index.php');
}

?>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../asset/style.css">
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <?php
    include('../layouts/sidebar.php')
    ?>
    <section class="home-section">
        <?php
        include('../layouts/header.php')
        ?>

        <div class="home-content">
            <div class="overview-boxes">
                <div class="box" style="width: 100%;display:block ">

                    <table class="table1">
                        <tr>
                            <td>ID</td>
                            <td>Nama Customer</td>
                            <td>Tanggal Masuk</td>
                            <td>Tanggal Diambil</td>
                            <td>Nama Paket</td>
                            <td>Harga/kg</td>
                            <td>Berat</td>
                            <td>Total</td>
                        </tr>
                        <?php
                        $qw = $db->query("
                            select a.*, b.nama as nama_paket, b.harga as harga_paket, c.nama as cust_nama
                            from transaksi a
                            left join paket b on a.paket_id = b.id
                            left join customer c on a.customer_id = c.id

                            order by a.id asc
                        ");
                        foreach ($qw as $data) {
                        ?>

                            <tr>
                                <td><?= $data['id'] ?></td>
                                <td><?= $data['cust_nama'] ?></td>
                                <td><?= $data['tgl_masuk'] ?></td>
                                <td><?= $data['tgl_diambil'] ?></td>
                                <td><?= $data['nama_paket'] ?></td>
                                <td>Rp. <?= number_format($data['harga_paket']) ?></td>
                                <td><?= $data['berat'] ?> KG</td>
                                <td>Rp. <?= number_format($data['total']) ?></td>
                            </tr>

                        <?php } ?>
                    </table>
                </div>
            </div>
        </div>

    </section>

    <script>
        let sidebar = document.querySelector(".sidebar");
        let sidebarBtn = document.querySelector(".sidebarBtn");
        sidebarBtn.onclick = function() {
            sidebar.classList.toggle("active");
            if (sidebar.classList.contains("active")) {
                sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
            } else
                sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
        }
    </script>
</body>
</html>