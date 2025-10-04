// Instancie manualmente (hard code) os objetos mostrados abaixo e mostre-os na tela do terminal, da seguinte forma:
// Title
// x Likes - dd/MM/yyyy HH:mm:ss
// Content
// Comments:
// 1comentariosijdfhnsd
// 2comentariosijdfhnsd

// Title
// x Likes - dd/MM/yyyy HH:mm:ss
// Content
// Comments:
// 1comentariosijdfhnsd
// 2comentariosijdfhnsd

import entities.Comment;
import entities.Post;

void main() {
    Comment c1 = new Comment("Have a nice trip!");
    Comment c2 = new Comment("Wow that's awesome!");

    Post p1 = new Post(
            LocalDateTime.parse("21/06/2018 13:05:44", Post.formatter),
            "Travelling to New Zeland",
            "I'm going to visit this wonderful country!",
            12
    );

    p1.addComment(c1);
    p1.addComment(c2);

    Comment c3 = new Comment("Good night");
    Comment c4 = new Comment("May the force be with you");

    Post p2 = new Post(
            LocalDateTime.parse("28/07/2018 21:14:19", Post.formatter),
            "Good night guys",
            "See you tomorrow",
            5
    );

    p2.addComment(c3);
    p2.addComment(c4);
    p2.addComment(c1);

    System.out.println(p1 + "\n\n");
    System.out.println(p2);

    //    p2.removeComment(c1);
    //    System.out.println(p1 + "\n\n");
    //    System.out.println(p2);
}