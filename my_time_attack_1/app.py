from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient
from datetime import datetime
from bson import ObjectId

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.dbStock


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/post', methods=['POST'])
def save_post():
    title_recive = request.form['title_give']
    content_recive = request.form['content_give']
    current_time = datetime.now()

    doc = {'title':title_recive,'content':content_recive,'day':current_time}
    db.dbStock.insert_one(doc)
    return jsonify({'msg': '업로드 완료!'})


@app.route('/post', methods=['GET'])
def get_post():
    posts = list(db.dbStock.find({}, {'_id': False}).sort("_id",-1))
    return jsonify({'posts': posts})
    return {"result": "success"}


@app.route('/post/delete', methods=['DELETE'])
def delete_post():
    post_id_recive = request.form['post_id_give']
    db.dbStock.delete_one({'_id': ObjectId(post_id_recive)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)