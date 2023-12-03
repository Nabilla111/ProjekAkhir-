<?php
session_start();

$_SESSION['title'] = 'Daftar Harga Customer';
$_SESSION['sidebar'] = 'customer';

include('../config/proses.php');

if(isset($_GET['delete'])){
    $db->delete("customer", "id = {$_GET['delete']}");
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

                    <div class="button">
                        <a href="form.php">Tambah Data Customer</a>
                    </div>

                    <table class="table1">
                        <tr>
                            <td>ID</td>
                            <td>Nama</td>
                            <td>Alamat</td>
                            <td>No Handphone</td>
                            <td>Aksi</td>
                        </tr>
                        <?php
                        $qw = $db->get("*", "customer");
                        $i = 0;
                        foreach ($qw as $data) {
                        $i++;
                        ?>

                            <tr>
                                <td><?php echo $i ?></td>
                                <td><?php echo $data['nama'] ?></td>
                                <td><?php echo $data['alamat'] ?></td>
                                <td><?php echo $data['no_hp'] ?></td>
                                <td>
                                    <div class="button">
                                        <a href="form.php?id=<?php echo $data['id'] ?>">Edit</a>
                                        <a href="?delete=<?php echo $data['id']; ?>&aksi=hapus" onclick="return confirm('Apakah anda yakin ingin menghapus data anda?')" class="danger" role="button">Hapus</a>
                                    </div>
                                </td>
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