package com.conchonha.bookmovietickets.database.callback;

import android.content.Context;
import android.content.SharedPreferences;

import com.conchonha.bookmovietickets.BuildConfig;
import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.database.table.Category;
import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.database.table.Film;
import com.conchonha.bookmovietickets.model.SettingDisplay;
import com.conchonha.bookmovietickets.model.TypeDisplayUI;
import com.conchonha.bookmovietickets.utils.Const;
import com.conchonha.bookmovietickets.utils.SharePrefs;

public class DumyData {
    public static Category[] listCategory = {
            new Category(
                    /*idCategory*/0,
                    "Hành động",
                    new Film[]{
                            /*ghi nhiều phim vào cho đẹp*/
                            new Film(
                                    /*id phim*/ 0,
                                    /*id category ở trên*/ 0,
                                    /*Tên film*/ "John Wick: Chapter 4",
                                    /*ngày chiếu*/ "24/03/2023",
                                    /*thời lượng phim*/"2 tiếng 45 phút",
                                    /*Mô tả phim*/"Kéo dài chỉ khoảng hơn một phút, nhưng đoạn teaser trailer của John Wick: Chapter 4 đã khiến cho mình cực kỳ háo hức chờ đợi. Ba phần đầu của John Wick rất hay, rất cuốn hút, nhưng có vẻ chỉ mới là bản lề cho một sự bùng nổ của những phần sau. Đừng quên rằng, tựa của Chapter 3 chỉ mới là “Chuẩn bị chiến tranh”, nên chắc chắn thế giới sát thủ và những cuộc chiến sâu sắc hơn sẽ còn chờ đợi chúng ta trong phần phim tiếp theo này.",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://photo2.tinhte.vn/data/attachment-files/2022/07/6067923_cover.jpg",
                                    "https://m.media-amazon.com/images/M/MV5BZDdkZTg0ZjYtNjIzNS00YzM3LWI4NzUtNmJiMWMxYmUwODg1XkEyXkFqcGdeQWFybm8@._V1_.jpg",
                                    "https://i.ytimg.com/vi/56pvThSsoSE/maxresdefault.jpg",
                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Keanu Reeves"
                            ),
                            new Film(
                                    /*id phim*/ 1,
                                    /*id category ở trên*/ 0,
                                    /*Tên film*/ "Aquaman và Vương Quốc Mất Tích",
                                    /*ngày chiếu*/ "16/12/2022",
                                    /*thời lượng phim*/"3 tiếng 15 phút",
                                    /*Mô tả phim*/"Aquaman and the Lost Kingdom Aquaman xây dựng một liên minh không dễ dàng với một đồng minh khó có thể cứu Atlantis và phần còn lại của hành tinh.  Riếp nối câu chuyện ở bộ phim Aquaman vào năm 2018. Khi lúc này, một sức mạnh từ thời cổ xưa bất ngờ được giải phóng khiến cho vương quốc Atlantis và các dân cư tại đây gặp nguy hiểm. Vì để có thể bảo vệ được vương quốc của mình. Aquaman đã nhanh chóng tạo ra một liên minh hùng mạnh để bảo vệ vương quốc khỏi sự tàn phá của sức mạnh cổ đại.",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://ap.cdnki.com/r_top-10-phim-chieu-rap-hay-nhat-thang-1-2022---685745f4fe39dcbd7f56aaab497abe61.webp",
                                    "https://vtv1.mediacdn.vn/zoom/700_438/2018/12/26/aquaman-15457978131311094598116.jpg",
                                    "https://br.atsit.in/vi/wp-content/uploads/2021/06/tieu-de-aquaman-2-do-james-wan-tiet-lo-aquaman-va-vuong-quoc-da-mat-aquaman.jpg",
                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Jason Momoa"
                            ),
                            new Film(
                                    /*id phim*/ 2,
                                    /*id category ở trên*/ 0,
                                    /*Tên film*/ "Avatar: The Way of Water",
                                    /*ngày chiếu*/ "15/12/2022",
                                    /*thời lượng phim*/"3 tiếng 12 phút",
                                    /*Mô tả phim*/"Cốt truyện của Avatar 2 được thực hiện 5 năm sau phần đầu tiên. Jack Sally, một cựu quân nhân tàn tật trên Trái đất, hiện là tộc trưởng của một bộ tộc Nami trên đảo Pandora, anh và người vợ yêu dấu Natalie có một cặp con xinh xắn, cuộc sống của họ rất bình dị và viên mãn. Tuy nhiên, một ngày nọ, một người anh em của bộ lạc đã bị giết khi cổ họng anh ta bị cắt bằng vũ khí sắc nhọn khi đang tuần tra gần bờ biển. Thông qua các cuộc kiểm tra tại chỗ và trực giác nhạy bén của mình với tư cách là một cựu lính thủy đánh bộ, Jack phán đoán rằng các hiện thân của con người đã trà trộn vào bộ tộc...",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_FMjpg_UX1000_.jpg",
                                    "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/12/review-avatar-2-the-way-of-water-5-696x392.jpg?fit=700%2C20000&quality=95&ssl=1",
                                    "https://image.thanhnien.vn/w1024/Uploaded/2022/tnabtw/2022_12_17/2011-0010-v04201075-altered-v2-2514.jpg",
                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Sam Worthington, Zoe Saldaña"
                            ),
                            new Film(
                                    /*id phim*/ 3,
                                    /*id category ở trên*/ 0,
                                    /*Tên film*/ "Morbius",
                                    /*ngày chiếu*/ "01/04/2022",
                                    /*thời lượng phim*/"1 tiếng 44 phút",
                                    /*Mô tả phim*/"Morbius Bộ phim xoay quanh tiến sĩ Michael Morbius (Jared Leto), một thiên tài từng đạt giải Nobel nhưng lại mắc chứng bệnh suy nhược máu, đe dọa nghiêm trọng đến tính mạng của bản thân. Sau khi nghiên cứu nhiều phương án nhưng không thu được kết quả khả quan, anh quyết định chơi liều một phen khi lợi dụng ma cà rồng kết hợp với sốc điện để giải quyết dứt điểm căn bệnh quái ác.",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://m.media-amazon.com/images/M/MV5BNTA3N2Q0ZTAtODJjNy00MmQzLWJlMmItOGFmNDI0ODgxN2QwXkEyXkFqcGdeQXVyMTM0NTUzNDIy._V1_FMjpg_UX1000_.jpg",
                                    "https://occ-0-32-38.1.nflxso.net/dnm/api/v6/6gmvu2hxdfnQ55LZZjyzYR4kzGk/AAAABcKc0BNDMGUDOqk4cl1CTTtOT4v55YyovKcHQaZ_Ohc8csuxMm5AYrKw0Lwz_xyR7G-JD86h9AJ91vm50zmAOtRkL471iDQuuvw6.jpg?r=d58",
                                    "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/title-key-art/morbius_onesheet_1400x2100_he.jpg?itok=-jQVkWIe",
                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Jared Leto, Matt Smith"
                            )
                    }
            ),
            new Category(
                    /*idCategory*/1,
                    "Hài hước",
                    new Film[]{
                            new Film(
                                    /*id phim*/ 4,
                                    /*id category ở trên*/1,
                                    /*Tên film*/ "Chìa Khóa Trăm Tỷ",
                                    /*ngày chiếu*/ "01/02/2022",
                                    /*thời lượng phim*/"1 giờ 57 phút",
                                    /*Mô tả phim*/"Chìa Khóa Trăm Tỷ là bộ phim hài chiếu rạp Việt Nam được đầu tư chất lượng từ kịch bản đến diễn xuất. Diễn viên chính trong phim được Kiều Minh Tuấn - Thu Trang đảm nhiệm. Bộ phim nói về câu chuyện hoán đổi cuộc sống bí ẩn bởi vì một chiếc chìa khóa trong phòng tắm công cộng, giữa một diễn viên quần chúng và một sát thủ.",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://static.mservice.io/blogscontents/momo-upload-api-220209102350-637799990308535572.jpg",
                                    "https://touchcinema.com/storage/phim-2021/chiakhoatramty.jpg",
                                    "https://kenh14cdn.com/thumb_w/640/pr/2022/mainposter960x600cfd498dd-fdd5-4e48-9cf3-d269d9045cbe-16431696498211281583016-0-0-600-960-crop-1643169660936-63778796790381.jpg",

                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Kiều Minh Tuấn, Thu Trang, Jun Vũ, NSUT Kim Xuân"
                            ),
                            new Film(
                                    /*id phim*/ 5,
                                    /*id category ở trên*/ 1,
                                    /*Tên film*/ "Cưới Em Đi",
                                    /*ngày chiếu*/ "11/02/2022",
                                    /*thời lượng phim*/"1 giờ 53 phút",
                                    /*Mô tả phim*/"Cưới Em Đi (Marry Me) là bộ phim chiếu rạp của Mỹ thuộc thể loại hài lãng mạn. Nội dung phim chủ yếu nói về cuộc hôn nhân không định sẵn của một siêu sao nổi tiếng và một fan hâm mộ sau khi cô dâu phát hiện hôn phu của mình lăng nhăng. Phim mang lại cho người xem những thước phim đẹp, những cái nhìn về hôn nhân, sự sẻ chia và cảm thông cho nhau. Cưới Em Đi là bộ phim hài đáng xem, không bó gọn trong khuôn khổ của thể loại hài- tình cảm mà có sự bức phá khác biệt.",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://i.ytimg.com/vi/kE-Z48_wkJE/maxresdefault.jpg",
                                    "https://chi-blog.com/wp-content/uploads/2022/03/marry_me_2_chi_blog.jpg",
                                    "https://znews-photo.zingcdn.me/w660/Uploaded/kbd_pilk/2022_02_13/marry_me1.jpg",
                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Jennifer Lopez, Owen Wilson, Maluma"
                            ),
                            new Film(
                                    /*id phim*/ 6,
                                    /*id category ở trên*/ 1,
                                    /*Tên film*/ "Love Destiny",
                                    /*ngày chiếu*/ "09/09/2022",
                                    /*thời lượng phim*/"2 giờ 46 phút",
                                    /*Mô tả phim*/"Sau khi ổn định cuộc sống cùng nhau và chỉ bị chia cắt trong cái chết trong thời đại Ayutthaya (1351-1767 CN), Dej và Karaket được tái sinh vào đầu thời kỳ Rattanakosin(1782-1855 CN). Nhưng chỉ có một người trong số họ vẫn tin vào 'định mệnh'. Bhop, một kỹ sư trưởng có nụ cười ngọt ngào nhất ở Siam, đã được nhìn thấy chính người phụ nữ trong mộng của anh ta trong nhiều năm. Anh hết lòng tin rằng cô là tri kỷ định mệnh của anh. Khi Bhop gặp Gaysorn, người trông giống hệt cô gái trong mơ của mình, Bhop đã đi theo cô ấy, cố gắng giành lấy trái tim của cô ấy. Tuy nhiên, Gaysorn có thái độ cầu tiến và không tin vào vận mệnh. Gaysorn bộc lộ rõ ​​ràng rằng cô không thích Bhop, nhưng cô lại thích Mathus, một người đàn ông Thái-Tây sử dụng tiếng lóng kỳ lạ khi nói chuyện, điều này trùng khớp với những thông điệp trong một tạp chí cũ của Lady Karaket. Mathus có du hành ngược thời gian từ tương lai như Lady Karaket không? Mối quan hệ của họ vẫn chưa được tìm ra, nhưng khi Bhop, Gaysorn và Mathus bị cuốn vào một sự kiện lịch sử hỗn loạn, mọi thứ vượt quá tầm kiểm soát và có thể dẫn đến một cuộc chiến sẽ thay đổi lịch sử mãi mãi.",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://cdn.galaxycine.vn/media/2022/8/30/1200wx1800h_1661793911854.jpg",
                                    "https://i.ytimg.com/vi/ShD0CvB9kWM/maxresdefault.jpg",
                                    "https://i.ytimg.com/vi/NdsNRrWI0tk/maxresdefault.jpg",
                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Chanon Santinatornkul, Chanon Santinatornkul"
                            ),
                            new Film(
                                    /*id phim*/ 7,
                                    /*id category ở trên*/ 1,
                                    /*Tên film*/ "Lyle, Lyle, Crocodile",
                                    /*ngày chiếu*/ "04/11/2022",
                                    /*thời lượng phim*/"1 giờ 47 phút",
                                    /*Mô tả phim*/"Vào một ngày đẹp trời, gia đình Primm chuyển đến thành phố New York nhộn nhịp. Thế nhưng, cậu con trai nhỏ Josh đang khá khó khăn khi thích nghi với trường lớp và bạn bè mới. Không lâu sau đó, mọi thứ dần trở nên tích cực hơn khi Josh phát hiện ra Lyle - chàng cá sấu mê tắm rửa, thích trứng cá muối và yêu âm nhạc sống trên gác mái của mình. Cả hai nhanh chóng hoà nhập và trở thành bạn thân.",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://m.media-amazon.com/images/M/MV5BYjNhZjA3MTctOTFjNi00Mjg5LTk3ODctOGZkNDMyMjY3YWNhXkEyXkFqcGdeQXVyMTI2ODM1ODUw._V1_.jpg",
                                    "https://www.cgv.vn/media/catalog/product/cache/3/image/c5f0a1eff4c394a251036189ccddaacd/p/o/poster_lyle_50x70cm_1_.jpg",
                                    "https://i.ytimg.com/vi/s0W6O7mSlaU/maxresdefault.jpg",
                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ " Shawn Mendes, Constance Wu, Javier Bardem"
                            )
                    }
            ),
            new Category(
                    /*idCategory*/2,
                    "Kinh dị",
                    new Film[]{
                            new Film(
                                    /*id phim*/ 8,
                                    /*id category ở trên*/ 2,
                                    /*Tên film*/ "Điện Thoại Đen",
                                    /*ngày chiếu*/ "23/06/2022",
                                    /*thời lượng phim*/"1 giờ 42 phút",
                                    /*Mô tả phim*/"Năm 1978, 5 đứa trẻ đột nhiên biến mất ở North Carolina. Finney Shaw 13 tuổi khôn ngoan và nhút nhát đã bị bắt cóc bởi một kẻ sát nhân máu lạnh và trở thành nạn nhân thứ 6 bị mắc kẹt trong một tầng hầm cách âm. Cậu bé hét lên để được giúp đỡ, nhưng không ai nghe cậu. Đột nhiên, một chiếc điện thoại vỡ trên tường vang lên, và cậu nhận ra rằng có thể nghe thấy giọng nói của những nạn nhân khác, người cũng từng bị mắc kẹt dưới tầng hầm. Họ cố gắng giúp Finney thoát khỏi vòng vây của kẻ sát nhân. Liệu cậu bé có trốn thoát và trở về nhà an toàn?",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://khenphim.com/wp-content/uploads/2022/06/The-Black-Phone-1-poster_KP.webp",
                                    "https://thuonghieuvaphapluat.vn/Images/Hanhnm/2021/10/14/phim-dien-thoai-den-02.jpg",
                                    "https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/b/l/black-phone-cgv.jpg",

                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Mason Thames, Madeleine McGraw, Jeremy Davies"
                            ),
                            new Film(
                                    /*id phim*/ 9,
                                    /*id category ở trên*/ 2,
                                    /*Tên film*/ "Ma Gương 3",
                                    /*ngày chiếu*/ "24/06/2022",
                                    /*thời lượng phim*/"1 giờ 45 phút",
                                    /*Mô tả phim*/"Dinda muốn có thể kiểm soát sức mạnh của mình, vì vậy cô đã theo học tại Trường Matahati, nơi những đứa trẻ có sức mạnh đặc biệt học cách kiểm soát sức mạnh của mình, nhưng những nguy hiểm bất ngờ luôn ở khắp mọi nơi và mọi bước của chúng liên tục xảy đến. Dinda có thể sống sót ở đó không?",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/m/a/main_poster_-_kuntilanak_3.jpg",
                                    "https://i.ytimg.com/vi/LhNvF2nBkwQ/maxresdefault.jpg",
                                    "https://i.imgur.com/v4sxPal.jpg",
                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Nicole Rossi, Andryan Bima, Ali Fikry"
                            ),
                            new Film(
                                    /*id phim*/ 10,
                                    /*id category ở trên*/ 2,
                                    /*Tên film*/ "Yêu Quái Toàn Thư",
                                    /*ngày chiếu*/ "04/11/2022",
                                    /*thời lượng phim*/"1 giờ 53 phút",
                                    /*Mô tả phim*/"“Đừng tò mò, cũng đừng nên mở ra!” là một trong những thông điệp khiến khán giả không khỏi chớp mắt với từng tình tiết trong phim. Câu chuyện kể về một cuốn sách cấm mang tên The Haunted Book. Cuốn sách này có thể biến mọi điều ước thành hiện thực. Để làm được điều đó, bạn phải trải qua một thử thách vô cùng nguy hiểm, thậm chí là mất mạng. Hãy cùng theo dõi xem thử thách đáng sợ đó là gì nhé!",
                                    /*Slide ảnh của phim*/ new String[]{
                                    "https://metiz.vn/media/poster_film/y_u_qu_i_to_n_th_-_payoff_poster_-_kt_facebook_-_kc_04112022_1_.jpg",
                                    "https://i.ytimg.com/vi/vGEkV_w61c4/sddefault.jpg",
                                    "https://tintuc-divineshop.cdn.vccloud.vn/wp-content/uploads/2022/11/yeu-quai-toan-thu-phan-nhin-on-nhung-thong-diep-lai-chua-sau-sac_63774acb8969d.jpeg",
                            },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Yui Aragaki, Ryûnosuke Kamiki, Ali Fikry"
                            )

                    }
            ),
    };

    public static Cinema[] listCinema = {new Cinema(10.827292250699022, 106.68929615538777, "CGV Vincom Gò Vấp", new String[]{
            /*list hình slide rạp phim*/ "https://lh3.googleusercontent.com/p/AF1QipMSw_QVrHxe01qLkzoXrbZpJWKDRS_WazyoBD4g=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipPJQMYpnR6AxDsEu5363DP2evg3bmnaNW2UsZVx=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipPa9jXghRLCP1hZcLRWIUs05WCsiOSXDyOf6SKb=s680-w680-h510"}, "https://gigamall.com.vn/data/2019/05/06/11365490_logo-cgv-500x500.jpg", "Tầng 5 TTTM Vincom Plaza Gò Vấp, 12 Phan Văn Trị, Phường 7, Quận Gò Vấp, TP.HCM", "https://www.cgv.vn/default/cinox/site/cgv-vincom-go-vap/"), new Cinema(10.827979661598807, 106.72121320000603, "CGV Giga Mall Thủ Đức", new String[]{"https://lh3.googleusercontent.com/p/AF1QipMCKHit97N7b9xHyTNchdUFx5EyYuzSWIuA5Bz3=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipN42cXAHu1aDT-d3FpIN3UMbItbqew7_BF3cEj8=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipM8I5Wxpama-57BtyJSrhOzlMTVVJAyXzXlVPIG=s680-w680-h510"}, "https://gigamall.com.vn/data/2019/05/06/11365490_logo-cgv-500x500.jpg", "Tầng 6 TTTM GIGAMALL, 240-242 Phạm Văn Đồng, Phường Hiệp Bình Chánh, Quận Thủ Đức, TP.HCM", "https://www.cgv.vn/default/cinox/site/cgv-vincom-thu-duc"), new Cinema(10.802397555965019, 106.61788876931556, "CGV Aeon Tân Phú", new String[]{"https://lh3.googleusercontent.com/p/AF1QipPIcU125MJgTNuGteSgkV-qlq4zd7GvD-kzqTVh=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipNB16A3pgTGnQzd1scwi7mvuUtJEiI1CSeeQvUV=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipM-dL_Iz4plfuwbM-Ni3YI-4zn72WKcFSNROaxu=s680-w680-h510"}, "https://gigamall.com.vn/data/2019/05/06/11365490_logo-cgv-500x500.jpg", "Tầng 3 Aeon Mall, 30 Bờ Bao Tân Thắng, Phường Sơn Kỳ, Quận Tân Phú, TP.HCM", "https://www.cgv.vn/default/cinox/site/cgv-celadon-tan-phu"), new Cinema(10.802377720913302, 106.7327131386311, "CGV Thảo Điền Pearl", new String[]{
            /*list hình slide rạp phim*/ "https://lh3.googleusercontent.com/p/AF1QipNGUvnVsiwERhzcowiUnJbcJ1FzrjYmQjH1ZZVj=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipNkkEmU9r2-UShGMUu3KQ9SGUgeU8fnu0YyzeaO=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipMHKU0bzFJmksWW4DTR6GlJ74LkYabfdYauRrNd=s680-w680-h510"}, "https://gigamall.com.vn/data/2019/05/06/11365490_logo-cgv-500x500.jpg", "Tầng 2 Thảo Điền Mall, 12 Quốc Hương, Phường Thảo Điền, Quận 2, TP.HCM", "https://www.cgv.vn/default/cinox/site/cgv-thao-dien-pearl"), new Cinema(10.799347907646863, 106.66010518465778, "CGV Hoàng Văn Thụ", new String[]{
            /*list hình slide rạp phim*/ "https://lh3.googleusercontent.com/p/AF1QipM8Ysbwn2PaL9zGIoJ0xm8Y30A5iGBkrfnLE71U=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipPW__ORyPib9xJfS0z1N2QQTuloue5wo3JSQ5f5=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipMSaGdaJJGxqI_Tbp2bPw5fsAIRex3EejX4YnGY=s680-w680-h510"}, "https://gigamall.com.vn/data/2019/05/06/11365490_logo-cgv-500x500.jpg", "Tầng 1 và 2 Gala Center, 415 Hoàng Văn Thụ, Phường 2, Quận Tân Bình, TP.HCM", "https://www.cgv.vn/default/cinox/site/cgv-hoang-van-thu"), new Cinema(10.73057056181241, 106.70443213068445, "CGV Vivo City", new String[]{
            /*list hình slide rạp phim*/ "https://lh3.googleusercontent.com/p/AF1QipM2GxVxx8eJw98fAj2n7AVrf2hl3HoC0nRWMVhO=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipM9Nb_YqYDUjDbdJBmI_g7kjM4IWlkYwIp2fH9J=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipNKGlqsCrknjWTcbzejGZyWdXFu8XmyX-d6AOjc=s680-w680-h510"}, "https://gigamall.com.vn/data/2019/05/06/11365490_logo-cgv-500x500.jpg", "Lầu 5 TTTM SC VivoCity, 1058 Nguyễn Văn Linh, Quận 7, TP.HCM", "https://www.cgv.vn/default/cinox/site/cgv-vivo-city"), new Cinema(10.789754528505707, 106.68573613068445, "CGV Lý Chính Thắng", new String[]{
            /*list hình slide rạp phim*/ "https://lh3.googleusercontent.com/p/AF1QipM3oLcGxM3LOH083YApFSPJaJYZXFQfRLGim-RC=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipO9AIt15Ri93qhj4GeaQKPBvRwCk-QKo2MyWhyX=s680-w680-h510", "https://lh3.googleusercontent.com/p/AF1QipM8IF0l8KdMNl7RF0fl5jEOCKwxYX-0AfZL22xW=s680-w680-h510"}, "https://gigamall.com.vn/data/2019/05/06/11365490_logo-cgv-500x500.jpg", "Tầng 3 83 Lý Chính Thắng, Phường 8, Quận 3, TP.HCM", "https://www.cgv.vn/default/cinox/site/cgv-ly-chinh-thang"),};

    public static SettingDisplay[] getListSetting(Context context) {
        final SharePrefs sharePrefs = new SharePrefs(context);
        return new SettingDisplay[]{new SettingDisplay(R.string.overview, TypeDisplayUI.TYPE_OVERVIEW, R.color.h2CB252, ""),
                new SettingDisplay(R.string.notification, TypeDisplayUI.TYPE_NOTIFICATION, R.color.colorStroke, "", false, true, sharePrefs.getSharedPref().getBoolean(Const.KEY_NOTIFY, false)),
                new SettingDisplay(R.string.display, TypeDisplayUI.TYPE_DEFAULT_SYSTEM, R.color.colorStroke, context.getString(R.string.default_system)),
                new SettingDisplay(R.string.language, TypeDisplayUI.TYPE_LANGUAGE, R.color.colorStroke, context.getString(R.string.vietnam)),
                new SettingDisplay(R.string.remove_cache, TypeDisplayUI.TYPE_REMOVE_CACHE, R.color.colorStroke, sharePrefs.calculateSizeRecursively(context) + " KB", true, false),
                new SettingDisplay(R.string.hotline, TypeDisplayUI.HOT_LINE_PHONE, R.color.h2CB252, ""),
                new SettingDisplay(R.string.hotline_phone, TypeDisplayUI.HOT_LINE_PHONE, R.color.colorStroke, "", true, false),
                new SettingDisplay(R.string.other, TypeDisplayUI.HOT_LINE_PHONE, R.color.h2CB252, ""),
                new SettingDisplay(R.string.version, TypeDisplayUI.TYPE_VERSION, R.color.colorStroke, BuildConfig.VERSION_NAME),
                new SettingDisplay(R.string.share, TypeDisplayUI.TYPE_SHARE, R.color.colorStroke, ""),
                new SettingDisplay(R.string.privacy, TypeDisplayUI.TYPE_PRIVACY, R.color.colorStroke, "")};
    }
}
