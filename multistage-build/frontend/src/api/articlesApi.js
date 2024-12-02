import api from "./axios";

const articlesApi = {
  getArticles: async () => {
    const resposne = await api.get("api/articles");
    return resposne.data;
  },
  postArticle: async (data) => {
    const resposne = await api.post(`api/articles`, data);
    return resposne.data;
  },
};

export default articlesApi;
