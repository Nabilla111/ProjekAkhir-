<?php
session_start();

$_SESSION['title'] = 'Form Paket';
$_SESSION['sidebar'] = 'paket';

include('../config/proses.php');

$data = [];
if(isset($_GET['id'])){
    $q = $db->get("*", "paket", "where id={$_GET['id']} LIMIT 1");
    foreach ($q as $item) {
        $data = $item;
    }
}

if( isset($_POST['nama']) && isset($_POST['harga']) ){
    if(isset($_GET['id'])){
        $q = $db->update(
            "paket",
            "nama = '{$_POST['nama']}', harga = '{$_POST['harga']}'", 
            "id={$_GET['id']}"
        );
    }else {
        $q = $db->insert(
            "paket",
            "nama, harga",
            "'{$_POST['nama']}', {$_POST['harga']}"
        );
    }

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
                <div class="box" style="width: 100%; justify-content:left;flex-wrap: wrap!important;">
                    <form method="POST" action="" style="width: 100%;">
                        <div class="form-group">
                            <p>ID</p>
                            <input type="text" name="id" value="<?= isset($_GET['id']) ? $_GET['id'] : '' ?>" disabled>
                        </div>

                        <div class="form-group">
                            <p>Nama</p>
                            <input type="text" name="nama" value="<?= isset($_GET['id']) ? $data['nama'] : '' ?>">
                        </div>

                        <div class="form-group">
                            <p>Harga</p>
                            <input type="text" name="harga" value="<?= isset($_GET['id']) ? $data['harga'] : '' ?>">
                        </div>
                    </form>
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