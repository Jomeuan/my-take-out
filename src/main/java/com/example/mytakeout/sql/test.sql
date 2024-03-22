insert into t_dish(
                gmt_create,
                gmt_modified,
                dish_name,
                introduction,
                image_path,
                price,
                dish_sort
        )
values (
                now(),
                now(),
                "test1", 
                "测试1",
                NULL,
                1.2,
                NULL);