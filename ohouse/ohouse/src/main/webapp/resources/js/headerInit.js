function init(data, callback) {
    $.ajax({
        url: "profile.co",
        data: { mNo: data },
        success: callback,
        error: function () {
            console.log("프로필 불러오기 실패")
        }
    })
}