package com.apps.sejarah.utils

import com.apps.sejarah.domain.model.Article

object DummyData {

    fun provideArticleList(): List<Article> {
        val articles = ArrayList<Article>()
        articles.add(
            Article(
                title = "Lubang Buaya",
                content = "Lubang Buaya adalah sebuah tempat di kawasan Pondok Gede, Jakarta yang menjadi tempat pembuangan para korban Gerakan 30 September (PKI) pada 30 September 1965. Secara spesifik, sumur Lubang Buaya terletak di Kelurahan Lubang Buaya di Kecamatan Cipayung, Jakarta Timur. Lubang Buaya pada terjadinya G30S saat itu merupakan pusat pelatihan milik Partai Komunis Indonesia. Saat ini di tempat tersebut berdiri Lapangan Peringatan Lubang Buaya yang berisi Monumen Pancasila, sebuah museum diorama, sumur tempat para korban dibuang, serta sebuah ruangan berisi relik. Nama Lubang Buaya sendiri berasal dari sebuah legenda yang menyatakan bahwa ada buaya-buaya putih di sungai yang terletak di dekat kawasan Pondok Gede. Selain itu juga terdapat rumah yang di dalamnya ketujuh pahlawan revolusi yang disiksa dan dibunuh. Dan juga terdapat mobil yang digunakan untuk mengangkut orang-orang.\n" +
                        "\n" +
                        "Sumber : wikipedia",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/2/2c/%22Sumur_Maut%22_at_Lubang_Buaya.jpg"
            )
        )
        articles.add(
            Article(
                title = "Kehidupan Zaman Praaksara",
                content = "Kehidupan zaman praaksara adalah kehidupan pada masa di mana catatan sejarah tertulis belum ada.\n" +
                        "Mengutip Kemdikbud RI, masa praaksara disebut juga masa prasejarah atau nirleka. Masa praaksara adalah zaman sebelum ditemukan tulisan atau zaman sebelum manusia mengenal tulisan.\n" +
                        "Manusia pada zaman praaksara antara lain Meganthropus Palaeojavanicus, Pithecanthropus Erectus, dan Homo Sapiens.\n" +
                        "Kehidupan masyarakat praaksara dibagi menjadi tiga masa, yaitu:\n" +
                        "\n" +
                        "1. Masa berburu dan mengumpulkan makanan\n" +
                        "\n" +
                        "2. Masa bercocok tanam\n" +
                        "\n" +
                        "3. Masa perundagian\n" +
                        "\n" +
                        "Sumber : Kompas.com",
                imageUrl = "https://buguruku.com/wp-content/uploads/2021/07/p24-800x445.jpg"
            )
        )
        articles.add(
            Article(
                title = "Kerajaan Hindu-Buddha di Indonesia",
                content = "Kerajaan Hindu-Buddha berdiri di Indonesia pada masa awal-awal masehi.\n" +
                        "Dari sekian banyak kerajaan tersebut, beberapa di antaranya berkembang cukup maju dan menjadi besar.\n" +
                        "Pada awalnya, kerajaan-kerajaan Hindu-Buddha di Indonesia menunjukkan adanya pengaruh kebudayaan India yang sangat kuat.\n" +
                        "\n" +
                        "Contohnya pada Kerajaan Kutai di Kalimantan dan Kerajaan Tarumanegara di Jawa Barat.\n" +
                        "Lambat laun, corak India semakin memudar karena kerajaan-kerajaan di Indonesia sudah mengembangkan kebudayaannya sendiri.\n" +
                        "\n" +
                        "Sumber : Kompas.com",
                imageUrl = "https://akcdn.detik.net.id/visual/2020/12/10/zona-rupadhatu-candi-borobudur_169.jpeg?w=650"
            )
        )
        return articles
    }
}