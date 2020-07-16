<template>
  <nav id="bar">
    <div class="list-group">
      <a href="#" class="list-group-item disabled" style="background-color:lightgray;">
        <div class="far fa-envelope"><strong>쪽지함</strong></div>
      </a>
      <router-link class="list-group-item" to="/MsgBox">받은 쪽지함</router-link>
      <router-link class="list-group-item" to="/MsgBox/MsgNew">새 쪽지 작성</router-link>
      <router-link class="list-group-item" to="/MsgBox/MsgMyHistory">보낸 쪽지함</router-link>
    </div>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      state: 0
    };
  },
  computed: {
  },
  methods: {
   
  },
};
</script>

<style scoped>
nav {
  /* border-radius: 25px; */
  border-radius: 15px 50px 30px 5px;
  margin-right: 10px;
  margin-left: 10px;
  margin-top: 110px;
  /* border: 1px solid; */
}
</style>