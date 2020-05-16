package mobilnoposlovanje.web.springmvcrest.bootstrap;

import mobilnoposlovanje.web.springmvcrest.domain.Product;
import mobilnoposlovanje.web.springmvcrest.domain.User;
import mobilnoposlovanje.web.springmvcrest.repositories.ProdictRepository;
import mobilnoposlovanje.web.springmvcrest.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ProdictRepository prodictRepository;

    public BootStrapData(UserRepository userRepository, ProdictRepository prodictRepository) {
        this.userRepository = userRepository;
        this.prodictRepository = prodictRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("loading data");
        //Users:
        User u1 = new User();
        u1.setEmail("pera@gmail.com");
        u1.setUsername("pera");
        u1.setName("pera");
        u1.setLastName("peric");
        u1.setIsAdmin(true);
        u1.setPassword("pera123");
        u1.setPicture("https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        userRepository.save(u1);

        User u2 = new User();
        u2.setEmail("aleksa@gmail.com");
        u2.setUsername("aleksa");
        u2.setName("aleksa");
        u2.setLastName("ivanovic");
        u2.setIsAdmin(false);
        u2.setPassword("aleksa123");
        u2.setPicture("https://cdn.cnn.com/cnnnext/dam/assets/171107102855-florida-state-fraternity-death-exlarge-169.jpg");
        userRepository.save(u2);

        User u3 = new User();
        u3.setEmail("milica@gmail.com");
        u3.setName("milica");
        u3.setUsername("milica");
        u3.setLastName("peric");
        u3.setIsAdmin(false);
        u3.setPassword("milica123");
        u3.setPicture("https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        userRepository.save(u3);

        System.out.println("users are saved: " + userRepository.count());

        //Products:
        Product p1 = new Product();
        p1.setAmount(1l);
        p1.setDesc("Hirurska maska koja stiti druge od Vase Korone.");
        p1.setImgUrl("https://www.radanprom.com/www.butobu.rs/members/butobu_shop/599373ab6aa5aba6033f7f60fae2f640/0.jpg");
        p1.setName("Hirurska maska za lice");
        p1.setPrice(200);
        prodictRepository.save(p1);

        Product p2 = new Product();
        p2.setAmount(1l);
        p2.setDesc("Maska sa filterom koja Vas stiti od cestica Korone iz vazduha.");
        p2.setImgUrl("https://bolago-m.rs/images/products/6151/800x800/albo-zastitna-maska-sa-filterom-jsp-kofil-ffp2-322.jpg?s=e80989305319449130f3405985818fa9");
        p2.setName("Maska za lice sa filterom");
        p2.setPrice(400);
        prodictRepository.save(p2);

        Product p3 = new Product();
        p3.setAmount(1l);
        p3.setDesc("Klinicki respirator za kad ste toliko bolesni da cete da riknete od Korone.");
        p3.setImgUrl("https://static.rtv.rs/slike/2020/03/19/novi-respiratori-kcs.jpg");
        p3.setName("Klinicki respirator");
        p3.setPrice(15000);
        prodictRepository.save(p3);

        System.out.println("Products saved:" + prodictRepository.count());
    }
}
