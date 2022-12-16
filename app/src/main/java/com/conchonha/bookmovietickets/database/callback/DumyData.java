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
                    "Tên Category",
                    new Film[]{
                            /*ghi nhiều phim vào cho đẹp*/
                            new Film(
                                    /*id phim*/ 0,
                                    /*id category ở trên*/ 0,
                                    /*Tên film*/ "phim Hot",
                                    /*ngày chiếu*/ "16/12/2022",
                                    /*thời lượng phim*/"1h30p",
                                    /*Mô tả phim*/"mô tả phim gi dài ra cho đẹp",
                                    /*Slide ảnh của phim*/ new String[]{
                                            "link địa chỉ hình",
                                            "link địa chỉ hình",
                                            "link địa chỉ hình",
                                     },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Abc"
                            ),
                            new Film(
                                    /*id phim*/ 1,
                                    /*id category ở trên*/ 0,
                                    /*Tên film*/ "phim Hot",
                                    /*ngày chiếu*/ "16/12/2022",
                                    /*thời lượng phim*/"1h30p",
                                    /*Mô tả phim*/"mô tả phim gi dài ra cho đẹp",
                                    /*Slide ảnh của phim*/ new String[]{
                                            "link địa chỉ hình",
                                            "link địa chỉ hình",
                                            "link địa chỉ hình",
                                      },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Abc"
                            )
                    }
            ),
            new Category(
                    /*idCategory*/1,
                    "Tên Category",
                    new Film[]{
                            new Film(
                                    /*id phim*/ 1,
                                    /*id category ở trên*/ 1,
                                    /*Tên film*/ "phim Hot",
                                    /*ngày chiếu*/ "16/12/2022",
                                    /*thời lượng phim*/"1h30p",
                                    /*Mô tả phim*/"mô tả phim gi dài ra cho đẹp",
                                    /*Slide ảnh của phim*/ new String[]{

                                    },
                                    /*Đánh giá*/ 2,
                                    /*Nhân vật chính*/ "Abc"
                            )
                    }
            ),
            /* Muốn bao nhiêu category hiển thị thì thêm vào đây*/
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
