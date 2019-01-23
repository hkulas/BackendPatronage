package com.hubertkulas.backendpatronage;

import com.hubertkulas.backendpatronage.model.Organization;
import com.hubertkulas.backendpatronage.repository.OrganizationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrganizationTest {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    public void returnRoomSample_whenGetOneIsCalled() {
        var organizationSample = organizationRepository.save(createSampleOrganization());
        var reservationRoomResult = organizationRepository.getOne(1l);
        assertThat(reservationRoomResult)
                .isEqualTo(organizationSample);
    }

    private Organization createSampleOrganization() {
        var organization = new Organization("IBM",null);
        return organization ;
    }
}
