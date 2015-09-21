package xyz.gutugutu3030;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import xyz.gutugutu3030.domain.Customer;
import xyz.gutugutu3030.processing.DemoFrame;
import xyz.gutugutu3030.repository.MyRepository;

@Component
public class Runner implements CommandLineRunner {
	@Autowired
	MyRepository repository;
	@Autowired
	DemoFrame frame;

	public void run(String... args) throws Exception {
		java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
//		processing=new Processing();
//		Insets insets=frame.getInsets();
//		frame.setSize(processing.width + insets.left + insets.right, processing.height + insets.top + insets.bottom);
//		frame.setResizable(false);
//		frame.add(processing);
//		frame.show();

		repository.save(new Customer(1,"Nobita","Nobi"));
		repository.save(new Customer(2,"Takeshi","Goda"));
		repository.save(new Customer(3,"Suneo","Honekawa"));
		repository.save(new Customer(null,"Hidetoshi","Dekisugi"));

		Page<Customer> page=repository.findAll(new PageRequest(0,3));
		System.out.println("1ページあたりのデータ数："+page.getSize());
		frame.setText("1ページあたりのデータ数："+page.getSize());
		System.out.println("現在のページ："+page.getNumber());
		System.out.println("全ページ数："+page.getTotalPages());
		System.out.println("全データ数："+page.getTotalElements());
		
		for(Customer c:page.getContent()){
			System.out.println(c);
		}
		System.out.println("---");

		//ユーザ定義クエリ
		for(Customer c:repository.findAllOrderByName2()){
			System.out.println(c);
		}
	}
}
