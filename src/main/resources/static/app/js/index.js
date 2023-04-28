let main = {
    init: function () {
        let _this = this;

        // 검색 버튼 클릭 이벤트 등록
        $(document).on('click', '#btnSearch', function () {
            _this.search();
        });
    },

    // 검색 기능 수행하는 함수
    search: function () {
        let keyword = $('#searchKeyword').val();

        if (keyword === '') {
            alert('검색어를 입력해주세요.');
            return;
        }

        // 검색 요청
        $.ajax({
            type: 'GET',
            url: '/api/v1/bibleVerse/' + keyword,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function (data) {
            if (data === null || data.content === null) {
                alert('검색 결과가 없습니다.');
            } else {
                let searchUrl = '/bibleVerses/search/result?keyword=' + keyword;
                searchUrl += '&bibleVerses=' + encodeURIComponent(JSON.stringify(data));
                window.location.href = searchUrl;
            }
            // 검색 결과가 생성된 후에 이벤트 핸들러를 다시 등록해줍니다.
            main.init();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
