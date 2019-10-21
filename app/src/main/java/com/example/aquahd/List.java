package com.example.aquahd;

public class List {

        String mName;
        String imageUrl;
        String add;
        String dept;

        public List() {
        }

        public List(String mName, String imageUrl, String add, String dept) {
            this.mName = mName;
            this.imageUrl = imageUrl;
            this.add = add;
            this.dept = dept;
        }

        public String getdept() {
            return dept;
        }

        public void setdept(String dept) {
            this.dept = dept;
        }

        //getter and setter
        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }

        public String getimageUrl() {
            return imageUrl;
        }

        public void setimageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }


        public String getAdd() {
            return add;
        }

        public void setAdd(String add) {
            this.add = add;
        }
    }




