# JSONObject和JSONArray的区别

* JSONObject 的数据是用{}来表示的

    ```json
    {
        "id": "123",
        "courseID": "huangt-test",
        "title": "提交作业",
        "content": null
    }
    ```

* JSONArray 顾名思义是由JSONObject构成的数组，用 [ { } , { } , ......  , { } ]  来表示

    ```json
    [   {
            "id": "123",
            "courseID": "huangt-test",
            "title": "提交作业"
        },
        {
            "content": null,
            "beginTime": 1398873600000,
            "endTime": 1398873600001
        }
    ]
    ```
