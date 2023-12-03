<?php
    $sidebar = $_SESSION['sidebar'];
?>
<div class="sidebar">
    <div class="logo-details">
        <i class='bx bx-closet'></i>
        <span class="logo_name">Laundry</span>
    </div>
    <ul class="nav-links">
        <li>
            <a href="../paket" class="<?php if($sidebar == 'paket') echo 'active'; ?>">
                <i class='bx bx-box'></i>
                <span class="links_name">Paket</span>
            </a>
        </li>
        <li>
            <a href="../customer" class="<?php if($sidebar == 'customer') echo 'active'; ?>">
                <i class='bx bx-credit-card-front'></i>
                <span class="links_name">Customer</span>
            </a>
        </li>
        <li>
            <a href="../transaksi/form.php" class="<?php if($sidebar == 'form transaksi') echo 'active'; ?>">
                <i class='bx bx-credit-card-front'></i>
                <span class="links_name">Form Transaksi</span>
            </a>
        </li>
        <li>
            <a href="../transaksi" class="<?php if($sidebar == 'daftar transaksi') echo 'active'; ?>">
                <i class='bx bx-list-ul'></i>
                <span class="links_name">Daftar Transaksi</span>
            </a>
        </li>

        <!-- <li class="log_out">
            <a href="../login/logout.php">
                <i class='bx bx-log-out'></i>
                <span class="links_name">Log out</span>
            </a>
        </li> -->
    </ul>
</div>