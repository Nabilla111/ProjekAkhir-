<?php
session_start();

$_SESSION['title'] = 'Form Customer';
$_SESSION['sidebar'] = 'customer';
$q = false;

include('../config/proses.php');

$data = [];
if(isset($_GET['id'])){
    $q = $db->get("*", "customer", "where id={$_GET['id']} LIMIT 1");
    foreach ($q as $item) {
        $data = $item;
    }
    $q = false;
}
// var_dump($data['nama']);
if( isset($_POST['nama']) && isset($_POST['alamat']) && isset($_POST['no_hp']) ){
    
    if(isset($_GET['id'])){
        $q = $db->update(
            "customer",
            "nama = '{$_POST['nama']}', alamat = '{$_POST['alamat']}', no_hp = '{$_POST['no_hp']}'",
            "id={$_GET['id']}"
        );
    }else {
        $q = $db->insert(
            "customer",
            "nama, alamat, no_hp",
            "
                '{$_POST['nama']}',
                '{$_POST['alamat']}',
                '{$_POST['no_hp']}'
            "
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
                            <p>Nama Lengkap</p>
                            <input type="text" name="nama" value="<?= isset($data['nama']) ? $data['nama'] : '' ?>" >
                        </div>

                        <div class="form-group">
                            <p>Alamat</p>
                            <input type="text" name="alamat" value="<?= isset($data['alamat']) ? $data['alamat'] : '' ?>" >
                        </div>

                        <div class="form-group">
                            <p>Nomor Handphone</p>
                            <input type="number" name="no_hp" value="<?= isset($data['no_hp']) ? $data['no_hp'] : '' ?>" >
                        </div>

                        <div class="button">
                            <button type="submit" class="">Kirim</button>
                        </div>

                        <div style="width:100%"></div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>

</html>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>  
    <?php if($q == true){ ?>
    Swal.fire({
        icon: 'success',
        title: 'Berhasil',
        text: 'Data berhasil diproses!',
    });
    <?php } ?>
</script>