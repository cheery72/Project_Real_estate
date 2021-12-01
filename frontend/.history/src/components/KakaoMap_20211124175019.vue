<template>
  <div>
    <div id="map">
    </div>
  </div>
</template>

<script>
import {mapState,mapMutations,mapActions} from "vuex";

export default {
  name: "KakaoMap",
  data() {
    return {
      map: null,
      markers: [],
      cctvmarkers: [],
      subwaymarkers: [],
      schoolmarkers: [],
      infowindow: null,
      markerUrl: require("@/assets/house.png"),
      markerCCTV: require("@/assets/cctv.png"),
      markerSubway: require("@/assets/subway.png"),
      markerSchool: require("@/assets/school.png"),
      aptImage: null,
      cctvImage: null,
      subwayImage: null,
      schoolImage: null,

    };
  },
  
  computed: {
    // 현재 셀렉트 박스에서 선택한 구,동 아파트들
    ...mapState(["positions","apts","cctvs","subways","schools"]),
  },

  watch: {
    apts(apt){
      this.displayMarker(apt);
    },
  },

  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey="+process.env.VUE_APP_KAKAO_API_KEY;
      document.head.appendChild(script);
    }
  },
  methods: {
    ...mapActions(["getCctvList","getSubwayList","getSchoolList"]),
    ...mapMutations(['SET_DETAIL_APT']),

    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.5951507, 126.9888111),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);

      var aptSrc = this.markerUrl, // 마커이미지의 주소입니다    
      aptSize = new kakao.maps.Size(50,50), // 마커이미지의 크기입니다
      aptOption = {offset: new kakao.maps.Point(50,50)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      this.aptImage = new kakao.maps.MarkerImage(aptSrc, aptSize, aptOption)

      var cctvSrc = this.markerCCTV, // 마커이미지의 주소입니다    
      cctvSize = new kakao.maps.Size(50,50), // 마커이미지의 크기입니다
      cctOption = {offset: new kakao.maps.Point(50,50)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      this.cctvImage = new kakao.maps.MarkerImage(cctvSrc, cctvSize, cctOption)

      var subwaySrc = this.markerSubway, // 마커이미지의 주소입니다    
      subwaySize = new kakao.maps.Size(50,50), // 마커이미지의 크기입니다
      subwayOption = {offset: new kakao.maps.Point(50,50)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      this.subwayImage = new kakao.maps.MarkerImage(subwaySrc, subwaySize, subwayOption)

      var schoolSrc = this.markerSchool, // 마커이미지의 주소입니다    
      schoolSize = new kakao.maps.Size(50,50), // 마커이미지의 크기입니다
      schoolOptoin = {offset: new kakao.maps.Point(50,50)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      this.schoolImage = new kakao.maps.MarkerImage(schoolSrc, schoolSize, schoolOptoin)

      this.getSubwayList();
      this.displayMarkerSubway(this.subways);
    },
    
    changeSize(size) {
      const container = document.getElementById("map");
      container.style.width = `${size}px`;
      container.style.height = `${size}px`;
      this.map.relayout();
    },
    displayMarker(markerPositions) {
      // 전에 찍었던 마커 지워줌
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      this.markers = [];
      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(position.lat,position.lng)
      );

      if (markerPositions.length > 0) {
        markerPositions.forEach((position) =>
            {
            const latln = new kakao.maps.LatLng(position.lat,position.lng);

            var marker = new kakao.maps.Marker({
              map: this.map,
              position: latln,
              image: this.aptImage,
            })
            // 마커에 표시할 인포윈도우를 생성합니다 
            var infowindow = new kakao.maps.InfoWindow({
              // 여기에 가격 넣어주면됨
                content: '<div>' + position.aptName+" "+position.recentPrice +'</div>'  , // 인포윈도우에 표시할 내용
                position: latln,
            })

            kakao.maps.event.addListener(marker, 'click',() => {
              this.SET_DETAIL_APT(position);

               
              // 지도에 표시할 원을 생성합니다
  var circle = new kakao.maps.Circle({
 // centerPosition : mouseEvent.latLng,

    center : new kakao.maps.LatLng(37.5769394, 127.0357027),  // 원의 중심좌표 입니다 
    radius: 50, // 미터 단위의 원의 반지름입니다 
    strokeWeight: 5, // 선의 두께입니다 
    strokeColor: '#75B8FA', // 선의 색깔입니다
    strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
    strokeStyle: 'dashed', // 선의 스타일 입니다
    fillColor: '#CFE7FF', // 채우기 색깔입니다
    fillOpacity: 0.7  // 채우기 불투명도 입니다   
}); 


// 지도에 원을 표시합니다 
circle.setMap(this.map); 
      

              infowindow.open(this.map, marker);
            });

            kakao.maps.event.addListener(marker, 'mouseout', this.makeOutListener(infowindow));
            
            this.markers.push(marker);
            
            }
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }

      this.displayMarkerCctv(this.cctvs);
      this.displayMarkerSchool(this.schools);
    },
    displayMarkerCctv(markerPositions) {
      // 전에 찍었던 마커 지워줌
      if (this.cctvmarkers.length > 0) {
        this.cctvmarkers.forEach((marker) => marker.setMap(null));
      }

      this.cctvmarkers = [];

      if (markerPositions.length > 0) {
        markerPositions.forEach((position) =>
            {
            const latln = new kakao.maps.LatLng(position.lat,position.lng);

            var marker = new kakao.maps.Marker({
              map: this.map,
              position: latln,
              image: this.cctvImage,
            })
            // 마커에 표시할 인포윈도우를 생성합니다 
            var infowindow = new kakao.maps.InfoWindow({
              // 여기에 가격 넣어주면됨
                content: '<div>' + position.aptName+" "+position.recentPrice +'</div>'  , // 인포윈도우에 표시할 내용
                position: latln,
            })

            kakao.maps.event.addListener(marker, 'click',() => {
              this.SET_DETAIL_APT(position);
              infowindow.open(this.map, marker);
            });

            kakao.maps.event.addListener(marker, 'mouseout', this.makeOutListener(infowindow));
            
            this.cctvmarkers.push(marker);
            
            }
        );
      }
    },

    displayMarkerSubway(markerPositions) {
      // 전에 찍었던 마커 지워줌

      if (markerPositions.length > 0) {
        markerPositions.forEach((position) =>
            {
            const latln = new kakao.maps.LatLng(position.lat,position.lng);
            var marker = new kakao.maps.Marker({
              map: this.map,
              position: latln,
              image: this.subwayImage,
            })
            // 마커에 표시할 인포윈도우를 생성합니다 
            var infowindow = new kakao.maps.InfoWindow({
              // 여기에 가격 넣어주면됨
                content: '<div>' +position.line+" "+position.name+'</div>'  , // 인포윈도우에 표시할 내용
                position: latln,
            })

            kakao.maps.event.addListener(marker, 'click',() => {
              this.SET_DETAIL_APT(position);
              infowindow.open(this.map, marker);
            });

            kakao.maps.event.addListener(marker, 'mouseout', this.makeOutListener(infowindow));
            
            }
        );
      }
    },
    displayMarkerSchool(markerPositions) {
      // 전에 찍었던 마커 지워줌
      if (this.schoolmarkers.length > 0) {
        this.schoolmarkers.forEach((marker) => marker.setMap(null));
      }

      this.schoolmarkers = [];

      if (markerPositions.length > 0) {
        markerPositions.forEach((position) =>
            {
            const latln = new kakao.maps.LatLng(position.lat,position.lng);

            var marker = new kakao.maps.Marker({
              map: this.map,
              position: latln,
              image: this.schoolImage,
            })
            // 마커에 표시할 인포윈도우를 생성합니다 
            var infowindow = new kakao.maps.InfoWindow({
              // 여기에 가격 넣어주면됨
                content: '<div>' + position.name+" "+position.addr +'</div>'  , // 인포윈도우에 표시할 내용
                position: latln,
            })

            kakao.maps.event.addListener(marker, 'click',() => {
              this.SET_DETAIL_APT(position);
              infowindow.open(this.map, marker);
            });

            kakao.maps.event.addListener(marker, 'mouseout', this.makeOutListener(infowindow));
            
            this.schoolmarkers.push(marker);
            
            }
        );
      }
    },

    // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
    // makeOverListener(map, marker, infowindow, position) {
    //   return function() { 
    //       console.log(position)
    //       infowindow.open(map, marker);
    //     };
    // },

    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
    makeOutListener(infowindow) {
        return function() {
            infowindow.close();
        };
    },

    displayInfoWindow() {
      if (this.infowindow && this.infowindow.getMap()) {
        //이미 생성한 인포윈도우가 있기 때문에 지도 중심좌표를 인포윈도우 좌표로 이동시킨다.
        this.map.setCenter(this.infowindow.getPosition());
        return;
      }

      var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwPosition = new kakao.maps.LatLng(33.450701, 126.570667), //인포윈도우 표시 위치입니다
        iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

      this.infowindow = new kakao.maps.InfoWindow({
        map: this.map, // 인포윈도우가 표시될 지도
        position: iwPosition,
        content: iwContent,
        removable: iwRemoveable,
      });

      this.map.setCenter(iwPosition);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: 100%;
  height: 700px;
}

.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>