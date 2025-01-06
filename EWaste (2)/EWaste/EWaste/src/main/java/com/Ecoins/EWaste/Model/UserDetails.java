package com.Ecoins.EWaste.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "UserDetails")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USER_ID")
    private int USER_ID;

    @Column(name = "CREATED_DT_BY")
    private OffsetDateTime CREATED_DT_BY;

    @Column(name = "UPDATED_DT_BY")
    private OffsetDateTime UPDATED_DT_BY;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int USER_ID;
        private OffsetDateTime CREATED_DT_BY;
        private OffsetDateTime UPDATED_DT_BY;

        public Builder USER_ID(int USER_ID) {
            this.USER_ID = USER_ID;
            return this;
        }

        public Builder CREATED_DT_BY(OffsetDateTime CREATED_DT_BY) {
            this.CREATED_DT_BY = CREATED_DT_BY;
            return this;
        }

        public Builder UPDATED_DT_BY(OffsetDateTime UPDATED_DT_BY) {
            this.UPDATED_DT_BY = UPDATED_DT_BY;
            return this;
        }

        public UserDetails build() {
            UserDetails userDetails = new UserDetails();
            userDetails.USER_ID = this.USER_ID;
            userDetails.CREATED_DT_BY = this.CREATED_DT_BY;
            userDetails.UPDATED_DT_BY = this.UPDATED_DT_BY;
            return userDetails;
        }
    }
}
