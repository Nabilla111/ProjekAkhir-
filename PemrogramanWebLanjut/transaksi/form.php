<?php
session_start();

$_SESSION['title'] = 'Form Transaksi';
$_SESSION['sidebar'] = 'form transaksi';
$q = false;

include('../config/proses.php');

if( isset($_POST['paket_id']) && isset($_POST['customer_id']) && isset($_POST['berat']) && isset($_POST['tgl_masuk']) && isset($_POST['tgl_diambil']) && isset($_POST['total']) ){
    $q = $db->insert(
        "transaksi",
        "paket_id, customer_id, berat, tgl_masuk, tgl_diambil, total",
        "
            {$_POST['paket_id']},
            {$_POST['customer_id']},
            {$_POST['berat']},
            '{$_POST['tgl_masuk']}',
            '{$_POST['tgl_diambil']}',
            {$_POST['total']}
        "
    );
}

if( isset($_POST['user']) ) {
    $q = $db->insert(
        "customer",
        "user",
        "
            {$_POST['user']},
        "
    );
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
                            <p>Tanggal Masuk</p>
                            <input type="date" name="tgl_masuk">
                        </div>

                        <div class="form-group">
                            <p>Tanggal Diambil</p>
                            <input type="date" name="tgl_diambil">
                        </div>

                        <!-- <div style="width:100%"></div> -->

                        <div class="form-group">
                            <p>Nama Customer</p>
                            <select name="customer_id" id="">
                                <option value="">Pilih</option>
                                <?php
                                $qw = $db->get("*", "customer");
                                foreach ($qw as $data) {
                                ?>
                                    <option value="<?php echo $data['id'] ?>"><?php echo $data['nama'] ?></option>
                                <?php } ?>
                            </select>
                        </div>

                        <div class="form-group">
                            <p>Paket</p>
                            <select name="paket_id" id="">
                                <option value="">Pilih</option>
                                <?php
                                $qw = $db->get("*", "paket");
                                foreach ($qw as $data) {
                                ?>
                                    <option data-harga="<?php echo $data['harga'] ?>" value="<?php echo $data['id'] ?>"><?php echo $data['nama'] ?></option>
                                <?php } ?>
                            </select>
                        </div>

                        <div class="form-group">
                            <p>Harga</p>
                            <input type="text" name="harga" disabled>
                        </div>

                        <!-- <div style="width:100%"></div> -->

                        <div class="form-group">
                            <p>Berat <small>(kg)</small></p>
                            <input type="number" name="berat">
                        </div>

                        <div class="form-group">
                            <p>Total Harga</p>
                            <input type="text" name="total_harga" disabled>
                            <input type="text" name="total" style="display: none;">
                        </div>

                        <div class="button">
                            <button type="submit" class="">Kirim Data Transaksi</button>
                        </div>
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
    let harga_paket = null;
    $('select[name="paket_id"]').on('change', function() {
        harga_paket = $(this).find(':selected').data('harga');
        console.debug(harga_paket);

        $('input[name="harga"]').val(formatRupiah(harga_paket, 'Rp.'));
    });

    $('input[name="berat"]').on('keyup', function() {
        let total = harga_paket * $(this).val();

        $('input[name="total_harga"]').val(formatRupiah(total, 'Rp.'));
        $('input[name="total"]').val(total);
    });

    /* Fungsi formatRupiah */
    function formatRupiah(angka, prefix) {
        var number_string = angka.toString().replace(/[^,\d]/g, ''),
            split = number_string.split(','),
            sisa = split[0].length % 3,
            rupiah = split[0].substr(0, sisa),
            ribuan = split[0].substr(sisa).match(/\d{3}/gi);

        // tambahkan titik jika yang di input sudah menjadi angka ribuan
        if (ribuan) {
            separator = sisa ? '.' : '';
            rupiah += separator + ribuan.join('.');
        }

        rupiah = split[1] != undefined ? rupiah + ',' + split[1] : rupiah;
        return prefix == undefined ? rupiah : (rupiah ? 'Rp. ' + rupiah : '');
    }
    
    <?php if($q == true){ ?>
    Swal.fire({
        icon: 'success',
        title: 'Berhasil',
        text: 'Data berhasil diproses!',
    });
    <?php } ?>
</script>